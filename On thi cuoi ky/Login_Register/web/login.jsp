<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Login </h1>
        <form method="post" action="login">
            <div>
                <label>Username: </label>
                <input type="text" name="username">
            </div>
            
            <div>
                <label>Password: </label>
                <input type="password" name="password">
            </div>
            
            <button type="submit"> Submit </button>
            
            <a href="register.jsp" > 
                <button type="button"> Register </button>
            </a>
        </form>
        
    </body>
</html>
