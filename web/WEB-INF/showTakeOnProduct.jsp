<%-- 
    Document   : showTakeOnProduct
    Created on : 26.12.2019, 20:30:22
    Author     : LARISSA
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Продажа машины покупателю</title>

    </head>
    <body>
        <p>${info}</p>
        <a href="index.jsp">Главная страница</a><br>
        <form action="takeOnProduct" method="POST">
            <h2>Список машин</h2> 
            <select name="productId">
                <c:forEach var="product" items="${listProducts}" varStatus="status">
                    <option value="${product.id}">
                        ${status.index+1}) ${product.title}. ${product.model}. ${product.price}. ${product.quantity} 
                    </option>                          
                </c:forEach>
            </select>
            <h2>Список покупателей</h2>
            <select name="buyerId">
                <c:forEach var="buyer" items="${listBuyers}" varStatus="status">
                    <option value="${buyer.id}">
                        ${status.index+1}) ${buyer.name}. ${buyer.lastname}. ${buyer.email}. ${buyer.money}
                    </option>                          
                </c:forEach>
            </select>
            <input type="submit" value="Продать машину">
        </form>
    </body>
</html>
