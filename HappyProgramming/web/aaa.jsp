<%-- 
    Document   : aaaaaaaaaaaaaaaaa
    Created on : Oct 17, 2021, 1:25:38 PM
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
        <h1><c:out value="${sId}"></c:out></h1>
        <h1><c:out value="${name}"></c:out></h1>
        <c:if test="${mess!=null}">
            <c:out value="${mess}"></c:out>
        </c:if>
    </body>
</html>
