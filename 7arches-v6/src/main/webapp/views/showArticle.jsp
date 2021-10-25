<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	
	<h1 class="text-center">${article.titre}</h1>
	<div class="row">
		<div class="text-center col-sm-6 col-md-6 col-lg-6">
		
		<!-- <div class="col-md-2"> -->
		<img src="${contextPath }/img/${ article.imageCouvertureUrl }"
			alt="${ article.titre }" width="300" height="300">		
		</div>
	
		<div class="text-center col-sm-6 col-md-6 col-lg-6">
			<p>Prix : ${article.prixHt} euros</p>
			<p>Nombre de pages : ${article.nombrePages}</p>
			<p>Format : ${article.format}</p>
			<p>A propos de l'histoire : ${article.resume}</p>
		</div>
	</div>
	
	
	<div class="row m-2 text-center">
		<form action="${contextPath }/addArticle" method="post" class="my-2">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<input type=hidden name=id value="${article.id}">
			<input type="submit" class="btn btn-danger btn-margin" value="Ajouter">
		</form>
	</div>
	
<%@ include file="footer.jsp" %>
</body>
</html>