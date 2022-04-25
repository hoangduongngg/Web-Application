<%-- 
    Document   : edit
    Created on : Apr 2, 2022, 9:41:45 AM
    Author     : Dung
--%>

<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>
    </head>
    <body>
        <%
            if( request.getAttribute("product") != null ){
                Product p = (Product)request.getAttribute("product");
        %>
        <form action="edit" method="post">
            <label>Product Code:</label>
            <input type="text" name="code" readonly="" value="<%= p.getCode() %>"><br>
            <label>Product Description</label>
            <input type="text" name="description" value="<%= p.getDescription() %>"><br>
            <label>Product Price</label>
            <input type="text" name="cost" value="<%= p.getPrice() %>"><br>
            <input type="submit" value="Edit Product">   
        </form>
        <%
            }
        %>
        
    </body>
</html>
