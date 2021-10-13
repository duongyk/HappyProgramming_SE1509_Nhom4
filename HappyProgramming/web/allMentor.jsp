

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach items="${mList}" var="mentor">
            <p>${mentor.fullname}
            <a href="RatingControllerMap?service=getRating&mId=${mentor.id}">See rating</a>
             <a href="CVControllerMap?service=cvMentor&mId=${mentor.id}">View CV of mentor</a>
        </c:forEach>
    </body>
</html>
