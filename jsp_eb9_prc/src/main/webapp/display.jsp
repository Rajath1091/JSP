<%@page import="com.ty.jsp_eb9_prc.dto.Employee"%>
<%@page import="java.util.List"%>
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
	String name = (String) request.getAttribute("name");
	if (name != null) {
	%>
	<h3>
		Changed by
		<%=name%></h3>
	<%
	}
	%>
	<%
	List<Employee> employees = (List) request.getAttribute("employees");
	%>
	<table border="2px solid">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Address</th>
			<th>Phone</th>
			<th>Email</th>
			<th>Password</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		<%
		for (Employee employee : employees) {
		%>
		<tr>
			<td><%=employee.getId()%></td>
			<td><%=employee.getName()%></td>
			<td><%=employee.getAddress()%></td>
			<td><%=employee.getPhone()%></td>
			<td><%=employee.getEmail()%></td>
			<td><%=employee.getPassword()%></td>
			<td><a href="delete?id=<%=employee.getId()%>"><button>DELETE</button></a></td>
			<td><a href="update?id=<%=employee.getId()%>"><button>UPDATE</button></a></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>