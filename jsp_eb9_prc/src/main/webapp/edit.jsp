<%@page import="com.ty.jsp_eb9_prc.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	Employee employee = (Employee) request.getAttribute("employee");
	%>
	<form action="edit" method="post">
		<table>
			<tr>
				<td>Id :</td>
				<td><input type="number" name="id" placeholder="Enter your id"
					value=<%=employee.getId()%> readonly=true></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name"
					placeholder="Enter your name" value=<%=employee.getName()%>></td>
			</tr>
			<tr>
				<td>Address :</td>
				<td><input type="text" name="address"
					placeholder="Enter your address" value=<%=employee.getAddress()%>></td>
			</tr>
			<tr>
				<td>Phone :</td>
				<td><input type="tel" name="phone"
					placeholder="Enter your phone" value=<%=employee.getPhone()%>></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><input type="email" name="email"
					placeholder="Enter your email" value=<%=employee.getEmail()%>></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password"
					placeholder="Enter your password" value=<%=employee.getPassword()%>></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update"></td>
			</tr>
		</table>
	</form>
</body>
</html>