<%-- 
    Document   : search
    Created on : Jun 21, 2022, 3:13:00 PM
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
    <body>
        <h1>Search:</h1>
        
        <table>
            <tr>
                <th>BookCode</th>
                <th>Title</th> 
                <th>Author</th> 
                <th>Category</th> 
                <th>Booked</th>
            </tr>
            
            <c:forEach items="${listB}" var = "o">
                <tr>
                    <td>${o.bookcode}</td>
                    
                    <td>${o.title}</td> 
                    <td>${o.author}</td> 
                    <td>${o.category}</td> 
                    
                    <c:if test="${o.booked == 1}">
                        <td>Booked</td>
                    </c:if>
                    <c:if test="${o.booked == 0}">
                        <td>
                            <a href="book?bookcode=${o.bookcode}">
                                <button type="submit">Book</button>
                            </a>
                           
                        </td>
                        
                    </c:if>
                    
                </tr>
                
            </c:forEach>
            
            
        </table>
    </body>
</html>
