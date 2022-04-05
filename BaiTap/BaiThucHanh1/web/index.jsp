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
                <a href="register.jsp">
                    <button type="button">Register</button> 
                </a>

            </div>
            
            <!--<input action="register" type="submit" id="register" value="Register">-->
            <h5 style="color: red">${announcement}</h5>  
            <h5>Tong so lan truy cap: ${hits_counter}</h5>
        </form>
    </body>
</html>
