<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.error{
color: #ff0000;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h2>Add Pizza Details</h2>
		<form:form action="savePizza.html" method="get" modelAttribute="pizza">
			<table border="3">
				<tr>
					<td>Customer Name</td>
					<td><form:input path="customerName" /></td>
				</tr>
				<tr>
					<td>Customer Contact</td>
					<td><form:input path="contactNumber" /></td>
				</tr>
				<tr>
					<td>Pizza Name</td>
					<td><form:select path="pizzaId">
							<form:option value="" label="--Select--"></form:option>
							<form:options items="${nameList}" />
						</form:select></td>
				</tr>
				<tr>
					<td>Quantity</td>
					<td><form:input path="numberOfPiecesOrdered" /></td>
				</tr>
			</table>
			<input type="submit" value="Order" /><br>
			<form:errors path="*" cssClass="error"></form:errors>
		</form:form>
		<a href="index.jsp">Home</a>
	</center>
</body>
</html>