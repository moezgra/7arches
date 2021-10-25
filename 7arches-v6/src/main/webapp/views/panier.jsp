<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="fr-FR">
<meta charset="utf-8">
<head>
  <title>7arches bookstore</title>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
  <script src="${contextPath}/resources/js/jquery.min.js"></script>
  <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="css/style.css"> 
</head>
<body>
<%@ include file="header.jsp"%>

<!-- <title>Panier</title> -->

	<h2>Votre panier contient :</h2>
	
	<table class="table table-striped p-2">
		<thead>
			<tr>
				<th>Article(s)</th>
				<th>Quantité</th>
				<th>Prix unitaire</th>
				<th>Prix total</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${panier.getLignesPanier().size() == 0 }">
				<tr>
					<td colspan="4" class="text-center">
						Votre panier est vide! Faites-vous plaisir...
					</td>
				</tr>
			</c:if>
			<c:if test="${panier.getLignesPanier().size() != 0 }">
				<c:forEach items="${panier.getLignesPanier() }" var="ligne">
					<tr>
						<td>${ligne.article.titre}</td>
						
						<td>
						
							<form action="${ pageContext.request.contextPath }/modifQuantity" method="post" class="my-2">
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								<input type=hidden name=id value="${ligne.article.id}">
								<input type="number" name=qte min=0 class="form-control-sm" value="${ligne.qte }" onchange="this.form.submit()">
							</form>
							
						</td>
						<td>${ligne.article.prixHt }</td>
						<td>${ligne.article.prixHt * ligne.qte}</td>
						<td>
							<form action = "${ pageContext.request.contextPath }/deleteArticle" method="get" class="my-2">
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								<input type=hidden name=id value="${ligne.article.id}">
								<input type="submit" class="btn btn-sm" value="Supprimer">
							</form>
							
						</td>
					</tr>
				
				</c:forEach>
				
			</c:if>
			
		</tbody>
		<tfoot>
			<tr>
				<td colspan="3" class="text-right"><h3>Prix total panier :</h3></td>
				<td class="text-right"><h3>EUR <c:out value="${panier.prixTotalPanier() }"></c:out></h3></td>
			</tr>
		</tfoot>
	</table>
	
	
	<div class="row">
		<div class="col-sm-4 col-md-4 col-lg-4"></div>
		<div class="text-center col-sm-2 col-md-2 col-lg-2">
				<form action="${contextPath }/showArticles" method="GET">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<input class="btn btn-sm m-1 btn-primary" type="submit" value="Continuer vos achats">
				</form>
				
				
		</div>
		
		<div class="text-center col-sm-2 col-md-2 col-lg-2">
			<form action="${contextPath }/validationCart" method="GET">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<input class="btn btn-sm m-1 btn-primary" type="submit" value="Passer la commande">
			</form>
		</div>
		<div class="col-sm-4 col-md-4 col-lg-4"></div>
	</div>
	<%-- <c:forEach items="${ panier.getLignesPanier() }" var="ligne">

		<h2>Article : ${ligne.article.titre}</h2>
		<h2>Quantité : ${ ligne.qte } </h2>
		<h2>Prix : ${ligne.article.prixHt} euros</h2>
		<h2>Prix total : ${ligne.article.prixHt * ligne.qte} euros</h2>
		
		<h2>Prix : ${ ligne.article.prixHt }
		<form action="modifQuantity" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<input type=hidden name=id value="${ligne.article.id}">
			<input type="submit" name="op" value="+"> 
			<input type="submit" name="op" value="-">
			<!-- <input type="submit" value="Validation"> -->
		</form>

	</c:forEach>
 		<h2>Prix total panier : <c:out value = "${ panier.prixTotalPanier() }"></c:out>euros</h2> --%>
<%@ include file="footer.jsp"%>

<script type="text/javascript">

</script >