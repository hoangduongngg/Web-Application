<%-- 
    Document   : delete
    Created on : Mar 31, 2022, 10:06:52 PM
    Author     : Dung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Are you sure you want to delete this product</h1>
        <form action="confirm">
            <label>Product Code: </label>
            <span>${product.code}</span><br>
            <input type="hidden" value="${product.code}" name="code">
            <label>Product Description: </label>
            <span>${product.description}</span><br>
            <label>Product Price: </label>
            <span>${product.price}</span><br>
            <input type="submit" value="Yes" name="btn">
            <input type="submit" value="No" name="btn">
        </form>
    </body>
</html>
