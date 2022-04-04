<%-- 
    Document   : index
    Created on : Apr 4, 2022, 11:24:31 PM
    Author     : hoangduongngg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="post">
            <div>
                <input type="text" name="username" placeholder="username"> <br>
                <input type="text" name="password" placeholder="password"> <br>
                <input type="button" id="login" value="Log In">
                <input type="button" id="register" value="Register">
            </div>
        </form>
    </body>
</html>
