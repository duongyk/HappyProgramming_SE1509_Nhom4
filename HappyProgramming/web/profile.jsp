<%-- 
    Document   : profile
    Created on : Sep 23, 2021, 8:14:17 PM
    Author     : Duong
--%>

<%@page import="entity.User"%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Profile!</h1>
        <p>${user.fullname}
        <p>${user.mail}
        <p>${user.phone}
        <p>${user.dob}
        <p>${user.gender}
        

        <c:choose>
            <c:when test="${user.role==1}">               
              <a href="${"UserControllerMap?service=updateProfile&uId="}${user.id}">Update Profile</a><br>
            </c:when>
              <c:otherwise>            
              <img src="images/${user.avatar}" style="width: 162px;"/>
              <a href="${"CVControllerMap?service=updateCV&uid="}${user.id}">Update CV</a><br>
            </c:otherwise>
        </c:choose>
        <a href="UserControllerMap?service=signOut">Sign Out</a>
    </body>
</html>
