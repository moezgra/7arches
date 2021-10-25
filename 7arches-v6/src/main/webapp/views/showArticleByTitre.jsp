<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="fr-FR">
<meta charset="utf-8">
<head>
  <title>7arches bookstore</title>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/style.css"> 
</head>
<body>

<%@ include file="header.jsp"%>

<h1>Article(s) trouvé(s) :</h1>
	<div class="container">
	
		<div class="row">
			<c:forEach items="${ articles }" var="article">

				<%-- 			<c:out value="${ article.titre } ${ article.prixHt } ${ article.tauxTva } ${ article.numIsbn } --%>
				<%-- 			 ${ article.format } ${ article.resume } ${ article.nombrePages } ${ article.quantiteEnStock }" /> --%>

				<div class="col-md-3">
					<a href="showArticle/${ article.id }"> <img
						src="img/${ article.imageCouvertureUrl }" alt="${ article.titre }"
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