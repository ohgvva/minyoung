<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error 500!!</title>
</head>
<body>
<h1>Error 500!!</h1>
<p>Error Type : <%= exception.getClass().getName() %> </p>
<p>Error Message : <%= exception.getMessage() %> </p>
<a href = "home"><button value="Welcome">HOME</button></a>
</body>
</html>