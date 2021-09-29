<%-- 
    Document   : skill
    Created on : Sep 23, 2021, 7:30:07 PM
    Author     : Duong
--%>

<%@page import="entity.Skill"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>
        <c:forEach var="x" items="${sList}">
            <p>${x.sId}   ${x.sName}   
            </c:forEach>  
            <br>
            <a href="AdminControllerMap?service=createSkill">Create Skill</a>
    </body>
</html>
