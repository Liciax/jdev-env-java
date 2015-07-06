<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>

	<h1>Pizza list</h1>

	<c:if test="${not empty pizzas}">
		<table border="1" style="width: 50%; text-align: center;">
			<tr>
				<th>ID</th>
				<th>NOM</th>
			</tr>

			<c:forEach var="pizza" items="${pizzas}">
				<tr>
					<td>${pizza.id}</td>
					<td>${pizza.nom}</td>
				</tr>
			</c:forEach>
		</table>


	</c:if>

	<h1>Ajout d'une nouvelle pizza</h1>

	<form:form method="POST" action="pizzas" commandName="initialPizza">
		<table>
			<tr>
				<td><form:label path="nom">Nom</form:label></td>
				<td><form:input path="nom" /></td>
				<td><input type="submit" value="Enregistrer" /></td>
			</tr>
		</table>
	</form:form>



</body>
</html>