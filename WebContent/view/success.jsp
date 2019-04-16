<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/styles/styles.css">
</head>
<body>
<%@ include file="header.jsp"%>
<h2>You entered Product details </h2>
<c:forEach var="prod" items="${requestScope.productDetails1}">
   <c:out value="${prod.pid}"/>
   <c:out value="${prod.name}"/>
   <c:out value="${prod.price}"/>
</c:forEach>  


</body>
</html>