<%-- 
    Document   : showAccount
    Created on : Mar 29, 2022, 11:41:29 PM
    Author     : hoangduongngg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Account</title>
    </head>
    <body>
<!--        <h3>${user}</h3>
        <h3>${pass}</h3>-->
        
        <h3>${sessionScope.user}</h3>
        <h3>${sessionScope.pass}</h3>

    </body>
</html>
