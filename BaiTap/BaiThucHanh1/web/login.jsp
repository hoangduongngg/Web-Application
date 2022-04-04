<%-- 
    Document   : login
    Created on : Apr 5, 2022, 12:06:04 AM
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
        <h3>${sessionScope.user.getUsername()}</h3>
    </body>
</html>
