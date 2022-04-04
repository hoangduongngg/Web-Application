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
        <form action="RegisterServlet" method="post">
            <div>
                <input type="text" name="username" placeholder="username"> <br>
                <input type="text" name="password" placeholder="password"> <br>
                <input type="submit" id="RegisterServlet" value="Register">
            </div>
        </form>
    </body>
</html>
