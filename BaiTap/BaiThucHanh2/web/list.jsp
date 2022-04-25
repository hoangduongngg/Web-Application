<%-- 
    Document   : list
    Created on : Apr 26, 2022, 12:12:54 AM
    Author     : hoangduongngg
--%>

<%@page import="java.util.List"%>
<%@page import="business.Product"%>
<%@page import="business.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Maintenance</title>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <style>
            table,th,td {
                border: 1px solid black;
                border-collapse: collapse;
            }
        </style>
    </head>
    <body>
        <h1>Products</h1>

        <table>
            <tr>
                <th>Code</th>
                <th>Description</th>
                <th>Price</th>
                <th>Action</th>
            </tr>
            <%
                List<Product> list = (List<Product>) request.getAttribute("data");
                for (Product x : list) {

            %>
            <tr>
                <td><%= x.getCode()%></td>
                <td><%= x.getDescription()%></td>
                <td><%= x.getPrice()%></td>
                <td>
                    <a href="edit?code=<%= x.getCode()%>">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?code=<%= x.getCode()%>">Delete</a>
                </td> 
            </tr>
            <%
                }
            %>
        </table>
        <br><br>
        <form action="new">
            <input type="submit" value="Add product">
        </form>
    </body>
</html>
