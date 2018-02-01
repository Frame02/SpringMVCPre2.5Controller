<%--
  Created by IntelliJ IDEA.
  User: vedantas
  Date: 2/1/2018
  Time: 12:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product Form</title>
    <meta charset="UTF-8">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>
<h1>Product Form</h1>
<c:if test="${requestScope.errors != null}">
    <ul>
    <c:forEach var="error" items="${requestScope.errors}">
        <li>
            <span style="color:red">${error}</span>
        </li>
    </c:forEach>
    </ul>
</c:if>


<form action="/product_save.action" method="post">
    <fieldset>
        <legend>Input Product Details</legend>
        <p>
            <label for="name">Name:&nbsp;</label>
            <input type="text" name="name" id="name" tabindex="1">
        </p>
        <p>
            <label for="description">Description:&nbsp;</label>
            <input type="text" name="description" id="description" tabindex="2">
        </p>
        <p>
            <label for="price">Price:&nbsp;</label>
            <input type="text" name="price" id="price" tabindex="3">
        </p>
        <div id="buttons">
            <p>
                <input type="reset" value="Reset" tabindex="4">
                <input type="submit" value="Submit" tabindex="5">
            </p>
        </div>
    </fieldset>
</form>

</body>
</html>
