<%-- 
    Document   : verfifyCode
    Created on : Oct 9, 2021, 7:44:10 PM
    Author     : Tung
--%>

<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verify Code</title>
    </head>
    <body>
        <div calss="container-fluid tm-mt-60">
            <div class="col-lg-12 col12 mb-5">
                <center><h2>Please verify your code</h2></center>
                <form action="UserControllerMap" method="get" >
                    <div class="form-group">
                        <input type="text" name="code" placeholder="Verify Code" required>
                    </div>
                    <div>
                        <button type="submit"> Verify </button>
                        <input type="hidden" name="service" value="verifyCode">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
