<%-- 
    Document   : profile
    Created on : Sep 23, 2021, 8:14:17 PM
    Author     : Duong
--%>

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
        <p>${user.uMail}
        <p>${user.uPhone}
        <p>${user.dob}
        <p>${user.gender}
        <p>${user.uAvatar}
        <a href="${"RatingControllerMap?service=getRating&uId=6"}">See rating</a><br>
        <a href="${"UserControllerMap?service=updateProfile&uId="}${user.uId}">Update Profile</a><br>
        <a href="UserControllerMap?service=signOut">Sign Out</a>
    </body>
</html>
