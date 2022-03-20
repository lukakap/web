<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page import="store.Product" %>
<%@ page import="store.Cart" %>
<%@ page import="java.util.HashMap" %>

<html>
<head>
<title> Shopping Cart </title>
</head>

<body>

<br>
<h1>Shopping Cart</h1>

<%
    char mark = '"';
    String strForm = "<form action= " + mark + "/shoppingCart" + mark +" method = " + mark + "post"+ mark + ">";
%>

<%! String printLineFor(Product prod, Integer num){
        String name = prod.getName();
        Double piecePrice = prod.getPrice();
        Double price = piecePrice * num;
        String symbol = prod.getProductID();
        char mark = '"';
        String input = "<input type =" +mark + "text" + mark + "value=" + mark + num + mark+ " name= " + mark + name + mark + ">";
        String str = input +" "+ name+ ", " + price;

        return  str;
    }
%>




<%! String printBottomPart(double total){
    char mark = '"';
    String str = "<br>";
    str += "<label for=" + mark + "update" + mark +">";
    str += "Total: $" + total;
    str += "</label>";
    str += "<button type=" + mark + "submit" +mark +" name =" + mark + "update" + mark + ">";
    str += "Update Cart";
    str += "</button>";
    return str;
}
%>

<ul>
<%
    Cart cart = (Cart)request.getSession().getAttribute("shoppingCart");
    HashMap<Product,Integer> productsInCart = cart.returnCart();
    Product prod;
    Integer num;
    double total = 0;
    out.print(strForm);
    for(Product key : productsInCart.keySet()) {
        out.print("<li>");
        out.print(printLineFor(key,productsInCart.get(key)));
        out.print("</li>");
        total += key.getPrice() * productsInCart.get(key);
    }
    out.print(printBottomPart(total));
    out.print("</form>");

%>
</ul>
<br>
<a href = "http://localhost:8080/"> Continue Shopping </a>




</body>
</html>