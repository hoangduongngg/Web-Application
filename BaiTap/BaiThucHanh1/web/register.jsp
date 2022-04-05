<%-- 
    Document   : register
    Created on : Apr 5, 2022, 1:00:27 AM
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
        <form action="register" method="post">
            <div>
                <input type="text" name="username" placeholder="username"> <br>
                <input type="password" name="password" placeholder="password"> <br>
                <input type="password" name="repassword" placeholder="repeat password"> <br>

                <input type="submit" id="register" value="Register">
            </div>
        </form>
        <h5 style="color: red">${announcement}</h5>    
    </body>
</html>
