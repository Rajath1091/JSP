<%@page import="com.ty.jsp_student_eb9_prc.dto.Student"%>
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
	List<Student> students = (List) request.getAttribute("students");
	%>
	<table border="2px solid">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Father's Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Fees</th>
			<th>Phone</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		<%
		for (Student student : students) {
		%>
		<tr>
			<td><%=student.getId()%></td>
			<td><%=student.getName()%></td>
			<td><%=student.getFather_name()%></td>
			<td><%=student.getEmail()%></td>
			<td><%=student.getPassword()%></td>
			<td><%=student.getFees()%></td>
			<td><%=student.getPhone()%></td>
			<td><a href="delete?id=<%=student.getId()%>"><button>DELETE</button></a></td>
			<td><a href="update?id=<%=student.getId()%>"><button>UPDATE</button></a></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>