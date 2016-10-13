<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="addPersonForm">
	<form action="addPerson" method="GET">
		<div>
			Name: <input type="text" name="name">
		</div>
		<div>
			Surname: <input type="text" name="surname" />
		</div>
		<input type="submit" value="Add" />
	</form>
</div>

<ul>
	<c:forEach items="${persons}" var="person">
		<li>
			${person.id} ${person.name} ${person.surname}
			<form action="deletePerson" method="GET">
				<input type="hidden" name="id" value="${person.id}" />
				<button type="submit">Remove</button>
			</form>
		</li>
	</c:forEach>
</ul>