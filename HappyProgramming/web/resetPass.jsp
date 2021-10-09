<%-- 
    Document   : resetPass
    Created on : Oct 9, 2021, 7:46:57 PM
    Author     : Tung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Password</title>
    </head>
    <body>
        <div calss="container-fluid tm-mt-60">
            <div class="col-lg-12 col12 mb-5">
                <center><h2>Reset Your Password</h2></center>
                <form action="UserControllerMap" method="get" >
                    <div class="form-group">
                        <input type="text" name="password" placeholder="Password" required>
                    </div>
                    <div class="form-group">
                        <input type="text" name="confirm" placeholder="Confirm Password" required>
                    </div>
                    <div>
                        <button type="submit"> Submit </button>
                        <input type="hidden" name="service" value="resetPass">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
