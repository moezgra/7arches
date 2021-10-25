<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<c:url var="showArticles" value="/showArticles"></c:url>



<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/style.css">

	
<div class="container text-center">
    <a href="${contextPath }/img/logo_7arches.png"></a><h1>Welcome to 7arches bookstore</h1>      
</div>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <!-- <a class="navbar-brand" href="#">Logo</a> -->
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <!-- <li class="active"><a href="#">Home</a></li> -->
        <li><a href="${ showArticles }">Products</a></li>
        <li><a href="${contextPath }/contact">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      	<c:if test="${pageContext.request.userPrincipal.name == null}">
        	<li><a href="${contextPath}/login"><span class="glyphicon glyphicon-log-in"></span> Log in</a></li>
         	<li><a href="${contextPath}/addClient"><span class="glyphicon glyphicon-user"></span> Your Account</a></li>
        </c:if>
      		
      	<c:if test="${pageContext.request.userPrincipal.name != null }">
      		<form id="logoutForm" method="POST" action="${contextPath}/logout">
            	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        	</form>
      		
      		<li><a onclick="document.forms['logoutForm'].submit()"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      	</c:if>
        <li><a href="${contextPath}/showPanier"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
      </ul>
      
      
	  </div> 
    </div>
</nav>























