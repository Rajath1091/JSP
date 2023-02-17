<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="save" method="post">
		<table>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name"
					placeholder="Enter your name"></td>
			</tr>
			<tr>
				<td>Father's Name :</td>
				<td><input type="text" name="father_name"
					placeholder="Enter your father's name"></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><input type="email" name="email"
					placeholder="Enter your email"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password"
					placeholder="Enter your password"></td>
			</tr>
			<tr>
				<td>Phone :</td>
				<td><input type="tel" name="phone"
					placeholder="Enter your phone"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>
	</form>
</body>
</html>