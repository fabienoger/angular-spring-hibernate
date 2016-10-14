<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<spring:url value="/css/hack.css" var="mainCss" />
		<spring:url value="/css/themes/solarized-dark.css" var="solarizedDarkTheme" />
		<spring:url value="/css/style.css" var="style" />
	
		<link rel="stylesheet" type="text/css" href="${mainCss}"/>
		<!-- dark-grey theme -->
		<link rel="stylesheet" type="text/css" href="${solarizedDarkTheme}"/>
		<link rel="stylesheet" type="text/css" href="${style}"/>
	</head>
	<body class="hack dark-grey container">
		<div class="grid">
			<div id="addPersonForm" class="cell 10of12">
				<form action="addPerson" method="GET" class="form">
					<fieldset class="form-group">
					  <label for="name">Name:</label>
					  <input id="name" name="name" type="text" placeholder="type your name..." class="form-control">
					</fieldset>
					<fieldset class="form-group">
					  <label for="surname">Surname:</label>
					  <input id="surname" name="surname" type="text" placeholder="type your surname..." class="form-control">
					</fieldset>
					<div class="form-actions">
						<input class="btn btn-primary" type="submit" value="Add" />
					</div>
				</form>
			</div>
			
			<ul class="cell 2of12 listPersons">
				<c:forEach items="${persons}" var="person">
					<li>
						${person.id} ${person.name} ${person.surname}
						<form action="deletePerson" method="GET" class="removePersonForm">
							<input type="hidden" name="id" value="${person.id}" />
							<button class="btn btn-error" type="submit">Remove</button>
						</form>
					</li>
				</c:forEach>
			</ul>
		</div>
	</body>
</html>