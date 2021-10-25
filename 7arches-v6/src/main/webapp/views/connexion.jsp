<%@ include file="header.jsp"%>
	<h2>Page de connexion</h2>
<!-- 	<form:form method="POST" modelAttribute="client" action="connexion/add"> -->
<!-- 		<div> -->
<!-- 			<!-- <form:label path="nom">Nom</form:label> -->
<!-- 			<form:input path="nom" /> --> -->
			
<!-- 		</div> -->
<!-- 		<div> -->
<!-- 			<form:label path="prenom">Prénom</form:label> -->
<!-- 			<form:input path="prenom" /> -->
<!-- 		</div> -->
<!-- 		<input type="submit" value="Ajouter"> -->
<!-- 	</form:form> -->
	<form method="POST" action="/addClient">
	<div>
	Nom : <input type="text" name="nom">
	</div>
	<div>
	Nom : <input type="text" name="prenom">
	</div>
	<button>Ajouter</button>
	</form>



</body>
</html>