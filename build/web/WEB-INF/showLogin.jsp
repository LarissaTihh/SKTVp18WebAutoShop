<%-- 
    Document   : showLogin
    Created on : 26.12.2019, 18:59:58
    Author     : LARISSA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Авторизация</title>
    </head>
    <body>
        <h1>Войдите!</h1>
     <p>${info}</p>      
      <form action="login" method="POST">
          Login: <input type="text" name="login"><br><br>
          Password: <input type="password" name="password"><br>
          <input type="submit" value="Go">
      </form>
    </body>

</html>

