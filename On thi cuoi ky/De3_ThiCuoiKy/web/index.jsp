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
        <h1>Home</h1>
        <form method="post" action="search">
            Bookcode: <input type="text" name="bookcode" value="${sessionScope.b.bookcode}"> <br>
            Title: <input type="text" name="title" value="${sessionScope.b.title}"> <br>
            Author: <input type="text" name="author" value="${sessionScope.b.author}"> <br>
            Category: <input type="text" name="category" value="${sessionScope.b.category}" > <br>
            
            <button type="submit" > Search </button>
        </form>
    </body>
</html>
