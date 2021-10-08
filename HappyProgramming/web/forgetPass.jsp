<%-- 
    Document   : forgetPass
    Created on : Oct 8, 2021, 12:39:09 AM
    Author     : Tung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot pass</title>
    </head>
    <body>
        <div calss="container-fluid tm-mt-60">
            <div class="col-lg-12 col12 mb-5">
                <center><h2>Forgot Password</h2></center>
                <form action="UserControllerMap" method="get" >
                    <div class="form-group">
                        <input type="email" name="email" placeholder="Email" required>
                    </div>
                    <div>
                        <button type="submit"> Submit </button>
                        <input type="hidden" name="service" value="resetPassword">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
