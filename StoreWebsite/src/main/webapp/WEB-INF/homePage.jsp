<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page import="store.Product" %>
<%@ page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
        <!DOCTYPE html>

<html>
<head>
<title> Student Store </title>
</head>

<body>
<h1>Student Store</h1>
<br>

<p>Items available:</p>

<ul>
<%! String printOut(Product product){
       String Id = product.getProductID();
       String name = product.getName();
       String inMarks = "http://localhost:8080/showProduct?id="+Id;
       char c = '"';
       return "<li><a href =" + c + inMarks + c + ">" + name + "</a></li>";
}
 %>


<%
    ArrayList<Product> listOfProducts = (ArrayList)request.getAttribute("productsList");
    for(Product product : listOfProducts) {
        out.print(printOut(product));
    }

%>

</ul>

</body>
</html>