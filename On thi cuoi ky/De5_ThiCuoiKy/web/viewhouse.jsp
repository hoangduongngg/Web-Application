<%-- 
    Document   : viewhouse
    Created on : Jun 25, 2022, 3:29:51 PM
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
        <h1>View House:</h1>
        
        <table>
            <tr>
                <th>ID</th> 
                <th>Address</th> 
                <th>Area</th> 
                <th>Type</th> 
                <th>Action</th>  
            </tr>
            
            <c:forEach items="${listH}" var="o">
                <tr>
                    <td>${o.id}</td> 
                    <td>${o.address}</td> 
                    <td>${o.area}</td> 
                    <td>${o.type}</td> 
                    <td>
                        <a href="approved?id=${o.id}">
                            <button>Approved</button>
                        </a>
                        <a href="delete?id=${o.id}">
                            <button>Delete</button>
                        </a>
                    </td>
                </tr>
                
            </c:forEach>
        </table>
    </body>
</html>
