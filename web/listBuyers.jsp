<%-- 
    Document   : listBuyers
    Created on : 26.12.2019, 20:21:38
    Author     : LARISSA
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список покупателей</title>
    </head>
    <body>
        <h1>Список наших покупателей</h1>
        <ol>
            <c:forEach var="buyer" items="${listBuyers}">
                 <li>${buyer.name}. ${buyer.lastname}. ${buyer.email} , ${buyer.money}</li>
            </c:forEach>
       
        </ol>
    </body>
</html>
