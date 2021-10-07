<%-- 
    Document   : editRequest
    Created on : Oct 5, 2021, 8:52:44 PM
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
        <form action="RequestControllerMap?service=editRequest" method="POST">
            <input type="hidden" name="rId" value="${req.id}">
            <h3>Title</h3>
            <input type="text" name="title" value="<c:out value="${req.title}"></c:out>" required="required">
                <h3>Content</h3>
                <input type="text" name="content" value="<c:out value="${req.content}"></c:out>" required="required">
                <h3>Deadline Date</h3>
                <input type="date" name="deadlineDate" value="<c:out value="${req.deadlineDate}"></c:out>" required="required">
                <h3>Deadline Hour</h3>
                <input type="text" name="deadlineHour" value="<c:out value="${req.deadlineHour}"></c:out>" required="required">
                <h3>Status</h3>
            <c:if test="${req.status==1}">
                <select name="status" required="required">
                    <option value="1" checked>Pending</option>
                    <option value="2">In process</option>
                    <option value="3">Done</option>
                    <option value="4">Cancel</option>
                </select>
            </c:if>
            <c:if test="${req.status==2}">
                <select name="status" required="required">
                    <option value="1">Pending</option>
                    <option value="2" checked>In process</option>
                    <option value="3">Done</option>
                    <option value="4">Cancel</option>
                </select>
            </c:if>
            <c:if test="${req.status==3}">
                <select name="status" required="required">
                    <option value="1">Pending</option>
                    <option value="2">In process</option>
                    <option value="3" checked>Done</option>
                    <option value="4">Cancel</option>
                </select>
            </c:if>
            <c:if test="${req.status==4}">
                <select name="status" required="required">
                    <option value="1">Pending</option>
                    <option value="2">In process</option>
                    <option value="3">Done</option>
                    <option value="4" checked>Cancel</option>
                </select>
            </c:if>
            <input type="submit" value="Submit" />
        </form>

    </body>
</html>
