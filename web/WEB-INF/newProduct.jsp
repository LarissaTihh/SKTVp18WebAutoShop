<%-- 
    Document   : newProduct
    Created on : 26.12.2019, 19:10:39
    Author     : LARISSA
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Новая машина</title>
    </head>
    <body>
        <h1>Создать новую машину</h1>
        <form action="addProduct" method="POST">
            Название машины: <input type="text" name="title"><br><br>
            Модель машины: <input type="text" name="model"><br><br>
            Стоимость машины: <input type="text" name="price"><br><br>
            Количество экземпляров: <input type="text" name="quantity"><br><br>
            Осталось таких машин: <input type="text" name="count"><br><br>
            <input type="submit" value="Создать машину"><br>
        </form>
    </body>
</html>
