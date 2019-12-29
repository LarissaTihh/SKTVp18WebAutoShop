<%-- 
    Document   : newBuyer
    Created on : 26.12.2019, 19:19:30
    Author     : LARISSA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Новый покупатель</title>
    </head>
    <body>
        <h1>Создать нового покупателя</h1>
        <form action="addBuyer" method="POST">
            Имя покупателя: <input type="text" name="name"><br><br>
            Фамилия покупателя: <input type="text" name="lastname"><br><br>
            E-майл: <input type="text" name="email"><br><br>
            Наличие денег: <input type="text" name="money"><br><br>
            <input type="submit" value="Создать покупателя"><br>
        </form>
    </body>
</html>
