<%-- 
    Document   : menteeManagement
    Created on : Oct 9, 2021, 8:49:30 PM
    Author     : Duong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List mentee</h1>
        <c:forEach items="${menteeList}" var="mentee">
            ${mentee.fullname} ${mentee.username}  <br>
        </c:forEach>
            <hr>
            <h2>Total mentee: ${menteeList.size()}</h2>
            <h2>Total hour  : ${totalHour}</h2>
            <h2>Total skill : ${totalSkill}</h2>
            <a href="AdminControllerMap?service=filterName">Filter Name</a>
    </body>
</html>
