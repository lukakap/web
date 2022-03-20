<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
<head>
<title> ${productName} </title>
</head>

<body>
<br>
<h1>${productName}</h1>
<br>

<%
String str = "";
char mark = '"';
str += "<img src = " + mark + "/store-images/" + request.getAttribute("productPicUrl") + mark + " >";
out.print(str);
%>


<br>



<form action = "/shoppingCart" method = "post">
    <label for="submit">$${productPrice}</label>
    <input type = "hidden" name = "hidden" value = ${productSymbol}>
    <input type = "submit" name = "submitAddToCart" value = "Add to Cart"/>
</form>






</body>

</html>