<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "A better greeting!" %> </h1>
<p>Products List:</p>
<ul>
    <%--@elvariable id="productsList" type="java.util.List"--%>
    <c:forEach var="product" items="${productsList}">
        <li>${product}</li>
    </c:forEach>
</ul>
<!-- <a href="hello-servlet">Hello Servlet</a> -->
</body>
</html>