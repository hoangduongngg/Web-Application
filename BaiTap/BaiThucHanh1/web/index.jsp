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
                <input type="password" name="password" placeholder="password"> <br>
                <input type="submit" id="login" value="Log In">
                
            </div>
            
            <!--<input action="register" type="submit" id="register" value="Register">-->
            <a href="register.jsp">Register</a>
            
        </form>
    </body>
</html>
