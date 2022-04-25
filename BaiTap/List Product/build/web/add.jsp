<%-- 
    Document   : add
    Created on : Apr 16, 2022, 9:56:20 AM
    Author     : Hieu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>
    </head>
    <body>
        <form action="add">
            <label>Product Code:</label>
            <input type="text" name="code"><br>
            <p><i>${message_code}</i></p>
            <label>Product Description</label>
            <input type="text" name="description" ><br>
            <p><i>${message_des}</i></p>
            <label>Product Price</label>
            <input type="text" name="cost" ><br>
            <p><i>${message_cost}</i></p>
            <input type="submit" value="Add Product" name="lc">&nbsp;&nbsp;&nbsp;
            <input type="submit" value="View Product" name="lc">
        </form>
        
    </body>
</html>
