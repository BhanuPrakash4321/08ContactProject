<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script>
function confirmDelete(){
	return confirm("Are you sure, you want to delete")
}
</script>




</head>
<body>
	<table>
		<thead>
			<tr>
				<td>Name</td>
				<td>Email</td>
				<td>Number</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contacts}" var="contacts">
				<tr>
					<th>${contact.contactName}</th>
					<th>${contact.contactEmail}</th>
					<th>${contact.contactNumber}</th>
					<td><a href="edit?cid=${contact.contactId}">Edit</a> <a href="delete?cid=${contact.contactId}" onclick="return confirmDelete()">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

</body>
</html>