<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styles/styles.css">
</head>
<body>
<%@ include file="view/header.jsp"%>
<form action="Search" method="post">
ProductName:<br>
<input type="text" name="name"/><br><br>
Price:<br>
<input type="text" name="price"/><br><br>
<input type="submit" value="OK"/>
</form>

</body>
</html>