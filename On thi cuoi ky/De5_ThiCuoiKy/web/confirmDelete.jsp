<%-- 
    Document   : confirmDelete
    Created on : Jun 25, 2022, 4:02:47 PM
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
        <h1>Delete House:</h1>
        
        <table>
            <tr>
                <th>ID</th> 
                <th>Address</th> 
                <th>Area</th> 
                <th>Type</th> 
            </tr>
            
                <tr>
                    <td>${house.id}</td> 
                    <td>${house.address}</td> 
                    <td>${house.area}</td> 
                    <td>${house.type}</td> 
                    
                </tr>
                
        </table>
                    
        <h3>Delete this House:</h3>
        <a href="confirmDelete?id=${house.id}">
                            <button>Confirm</button>
                        </a>
                        <a href="viewhouse">
                            <button>Cancel</button>
                        </a>
    </body>
</html>
