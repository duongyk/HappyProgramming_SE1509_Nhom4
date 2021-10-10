<%-- 
    Document   : viewRequest
    Created on : Oct 5, 2021, 8:34:18 PM
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
        <h1>From ${req.from.fullname}</h1>
        <h1>${req.title}</h1>
        <p>${req.content}</p>
        <h1> To ${req.to.fullname}</h1>
        <p>Deadline Date: ${req.deadlineDate}</p>
        <p>Hour: ${req.deadlineHour}</p>
        <c:if test="${req.status==1}">
            <p>Status: Pending</p>
        </c:if>
        <c:if test="${req.status==2}">
            <p>Status: Accepted</p>
        </c:if>
        <c:if test="${req.status==3}">
            <p>Status: Canceled</p>
        </c:if>
            <h2>Skill:
        <c:forEach items="${sList}" var="skill">
            <c:out value="${skill.name} "></c:out>
        </c:forEach>
            </h2>
        <a href="RequestControllerMap?service=editRequestForm&rId=${req.id}">Update request</a>
        <c:if test="${mess!=null}">
            <c:out value="${mess}"></c:out>
        </c:if>
    </body>
</html>
