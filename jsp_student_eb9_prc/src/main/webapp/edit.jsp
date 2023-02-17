<%@page import="com.ty.jsp_student_eb9_prc.dto.Student"%>
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
	Student student = (Student) request.getAttribute("student");
	%>
	<form action="edit" method="post">
		<table>
			<tr>
				<td>Id :</td>
				<td><input type="number" name="id" placeholder="Enter your id"
					value=<%=student.getId()%> readonly="readonly"></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name"
					placeholder="Enter your name" value=<%=student.getName()%>></td>
			</tr>
			<tr>
				<td>Father's Name :</td>
				<td><input type="text" name="father_name"
					placeholder="Enter your father's name"
					value=<%=student.getFather_name()%>></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><input type="email" name="email"
					placeholder="Enter your email" value=<%=student.getEmail()%>></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password"
					placeholder="Enter your password" value=<%=student.getPassword()%>></td>
			</tr>
			<tr>
				<td>Phone :</td>
				<td><input type="tel" name="phone"
					placeholder="Enter your phone" value=<%=student.getPhone()%>></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update"></td>
			</tr>
		</table>
	</form>
</body>
</html>