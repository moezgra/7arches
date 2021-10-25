<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>cart payment</title>
  <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
  <script src="${contextPath}/resources/js/jquery.min.js"></script>
  <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="text-center" style="margin: 2em;">
	
		<h2>Confirmation de commande</h2>
	
	<h3>Bonjour,</h3>
	<p><h4>Nous vous remercions de votre commande sur 7arches.<br>Nous vous tiendrons informés par e-mail lorsque les articles de votre commande auront été expédiés</h4>
	</p>
	</div>
</body>
</html>