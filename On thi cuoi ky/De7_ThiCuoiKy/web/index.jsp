<%-- 
    Document   : index
    Created on : Jun 28, 2022, 7:47:04 AM
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
        <h1>Home</h1>
        
        <form action="add">
            ID: <input type="text" name="id" value="${sessionScope.id}"> <br>
            Name: <input type="text" name="name" value="${sessionScope.name}"> <br>
            DOB:(yyyy-mm-dd): <input type="text" name="dob" value="${sessionScope.dob}"> <br> 
            <!--Department:<input type="text" name="department" value="${sessionScope.department}"> <br>-->
            Department:
            <select name="department" id="department">
                <option selected="${sessionScope.department}" >${sessionScope.department}</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
            </select>
            <br>
            <input type="submit" value="Add">
            <input type="button" value="Reset">
        </form>
    </body>
</html>
