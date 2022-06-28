<%-- 
    Document   : confirm
    Created on : Jun 28, 2022, 8:02:27 AM
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
        <h1>Confirm</h1>
        
        <form action="confirmAdd" method="post">
            <h3>${sessionScope.id}</h3> 
            <h3>${sessionScope.name}</h3> 
            <h3>${sessionScope.dob}</h3> 
            <h3>${sessionScope.department}</h3> 
            
            <input type="submit" value="Cofirm">
            <a href="index.jsp">
                <button type="button">Back</button>
            </a>
        </form>
        
        
        
    </body>
</html>
