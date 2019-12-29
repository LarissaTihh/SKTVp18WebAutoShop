<%-- 
    Document   : listProducts
    Created on : 26.12.2019, 19:45:43
    Author     : LARISSA
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список машин</title>
    </head>
    <body>
        <h1>Список машин в магазине</h1>
        <ol>
            <c:forEach var="product" items="${listProducts}">
                <li>${product.title}. ${product.model}. ${product.price}. ${product.quantity}. ${product.count}</li>  
            </c:forEach>
             </ol>
    </body>
</html>
