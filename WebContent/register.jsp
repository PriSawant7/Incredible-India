<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/stylesheet.css">

</head>


<body>
		<header>
			<b> Incredible India!</b>
		</header>
			<div class="flex-container">
		
		<div><%@ include file="menubar.jsp"%></div>
		<table>
		<tr><td><%@ include file="navigation.jsp"%></td>
		
		
		
<td><p>Please fill the below details. Fields marked in * are compulsory
</p>
<!-- <script type="text/javascript">
function myFunction() {
    alert("you have registered successfully!!!!!!! Continue to login");
}
</script>
 -->	<form action="register" method="post">
		<table class="regform">
			<tr>
				<td>First Name* :</td>
				<td><input type="text" name="firstName" required> <br>
					<br></td>
			</tr>
			<tr>
				<td>Last Name* :</td>
				<td><input type="text" name="lastName" required> <br>
				<br></td>
			</tr>
			<tr>
				<td>Email* :</td>
				<td><input type="email" name="email" required> <br>
					<br></td>
			</tr>
			<tr>
				<td>User Name* :</td>
				<td><input type="text" name="userName" required> <br>
					<br></td>
			</tr>
			<tr>
				<td>Password* :</td>
				<td><input type="password" name="password"
					pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
					title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
					required>
					<br> <br></td>
			</tr>


			<tr>
				<td><input type="submit"></td>
			</tr>

		</table>
		</td></tr>
		</table>
	</form>

</body>
</html>