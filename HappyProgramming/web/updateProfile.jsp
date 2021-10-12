<%-- 
    Document   : updateProfile
    Created on : Oct 12, 2021, 9:59:07 AM
    Author     : Tung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script class="u-script" type="text/javascript" src="js/changeAvatar.js" defer=""></script>
    </head>
    <body>
        <h1>Update profile</h1>
        <form action="UserControllerMap" method="POST">
            <input type="hidden" name="service" value="updateProfile">
            <input type="hidden" name="uId" value="${currUser.getId()}">
                <div>
                <div class="name">Fullname: </div>
                <input type="text" name="fullname" value="<c:out value="${currUser.getFullname()}"></c:out>" required>
                </div>
                <div>
                    <div class="name">Email: </div>
                    <input type="email" name="email" value="<c:out value="${currUser.getMail()}"></c:out>" required>
                </div>
                <div>
                    <div class="name">Phone: </div>
                    <input type="text" name="phone" value="<c:out value="${currUser.getPhone()}"></c:out>" required>
                </div>
                <div>
                    <div class="name">DOB: </div>
                    <input type="date" name="dob" value="<c:out value="${currUser.getDob()}"></c:out>" required>
                </div>
                <div>
                    <div class="name">Gender: </div>
                    <div>
                    <c:choose>
                        <c:when test="${currUser.getGender() == 'Male'}">
                            <select name="gender">
                                <option value="Male" selected>Male</option>
                                <option value="Female">Female</option>
                            </select>
                        </c:when>
                        <c:otherwise>
                            <select name="gender">
                                <option value="Male">Male</option>
                                <option value="Female" selected>Female</option>
                            </select>
                        </c:otherwise>
                    </c:choose> 
                    </div>
                </div>
                
                <div>
                    <div class="name">Avatar: </div>
                    <input id="avatarURL" name="avatar" type="file" pattern="^(https?|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]"
                           onchange="changeImage()" value="<c:out value="${currUser.getAvatar()}"></c:out>">
                </div>
                
                <div>
                    <button type="submit">Update</button>
                </div>
        </form>
    </body>
</html>
