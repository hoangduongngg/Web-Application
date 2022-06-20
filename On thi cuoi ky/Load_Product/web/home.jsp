<%-- 
    Document   : home
    Created on : Jun 20, 2022, 8:46:36 PM
    Author     : hoangduongngg
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>JSP Page</title>
    </head>
    <style>
        table , th, td, tr{
            border: black solid thin;
            border-width: 1px;
        }
        
    </style>
    <body>
        <h1>Home ${id} </h1>
<!--        <div>
            <h3>${product.id}</h3>
            <h3>${product.name}</h3>
            <h3>${product.des}</h3>
            <h3>${product.price}</h3>
        </div>-->
        
            
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Des</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                    
                    
                    <c:forEach items="${listP}" var="o">
                        <tr>       
                               <td>${o.id} </td>
                               <td>${o.name} </td>
                               <td>${o.des} </td> 
                               <td>${o.price} </td>
                               <td>
                                   <a href="edit?ProductID=${o.id}">Edit</a>
                                   <a href="delete?ProductID=${o.id}">Delete</a>
                               </td>
                          </tr>     
                    </c:forEach>
                    
                </table>
                
            
    <a href="add.jsp">Add Product</a>
    </body>
</html>
