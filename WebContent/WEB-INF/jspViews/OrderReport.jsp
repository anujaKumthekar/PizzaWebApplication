<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Order within Price Range Report</h1>
		<form:form action="orderList.html" method="get" modelAttribute="bill">
			<table border="2">
				<tr>
					<td>From Price:</td>
					<td><form:input path="fromPrice" /></td>
					<td>To Price:</td>
					<td><form:input path="toPrice" /></td>
				</tr>
			</table>
			<input type="submit" value="Fetch Details" />
			<br>
			
			<c:if test="${OrderList!= null || OrderList.isEmpty()}">
				<table border="2">
					<tr>
						<td><b>Order Id</b></td>
						<td><b>Customer Name</b></td>
						<td><b>PizzaId</b></td>
						<td><b>Bill</b></td>
						<td><b>Quantity</b></td>
					</tr>

					<c:forEach items="${OrderList}" var="orderlist">
						<tr>
							<td>${orderlist.orderId }</td>
							<td>${orderlist.customerName }</td>
							<td>${orderlist.pizzaId }</td>
							<td>${orderlist.bill }</td>
							<td>${orderlist.numberOfPiecesOrdered }</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
</form:form>
			<a href="index.jsp">Home</a>
	</center>
</body>
</html>