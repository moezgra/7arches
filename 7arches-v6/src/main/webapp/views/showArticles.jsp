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
	<form action="${ pageContext.request.contextPath }/showArticlesByTitre" method="post" class="my-2">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="text" placeholder="Search.." name="titre" id="titre">
		<input type="submit" value="Rechercher">
	</form> 
    
	<h1>Liste des articles</h1>
	<div class="container">
	
		<div class="row">
			<c:forEach items="${ articles }" var="article">

				<%-- 			<c:out value="${ article.titre } ${ article.prixHt } ${ article.tauxTva } ${ article.numIsbn } --%>
				<%-- 			 ${ article.format } ${ article.resume } ${ article.nombrePages } ${ article.quantiteEnStock }" /> --%>

				<div class="col-md-3">
					<a href="${contextPath }/showArticle/${ article.id }"> <img
						src="${contextPath }/img/${ article.imageCouvertureUrl }" alt="${ article.titre }"
						width="250" height="250">
					</a>
					<form action="${contextPath }/addArticle" method="POST" class="my-2">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<input type=hidden name=id value="${article.id}">
						<button type=submit class="btn btn-danger btn-margin">Ajouter</button>
					</form>
				</div>

			</c:forEach>
		</div>
	</div>
<%@ include file="footer.jsp" %>
</body>
</html>