<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="MailDispatcherServlet" method="post">
Email:<input type="email" name="toemail">  <br> 
Subject: <input type="text" name = "subject">
Message: <input type="text" name = "message">

<input type="submit">
</form>
</body>
</html>