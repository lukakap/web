/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-06-28 18:11:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import store.Product;
import store.Cart;
import java.util.HashMap;

public final class shoppingCart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 String printLineFor(Product prod, Integer num){
        String name = prod.getName();
        Double piecePrice = prod.getPrice();
        Double price = piecePrice * num;
        String symbol = prod.getProductID();
        char mark = '"';
        String input = "<input type =" +mark + "text" + mark + "value=" + mark + num + mark+ " name= " + mark + name + mark + ">";
        String str = input +" "+ name+ ", " + price;

        return  str;
    }

 String printBottomPart(double total){
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

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title> Shopping Cart </title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<br>\r\n");
      out.write("<h1>Shopping Cart</h1>\r\n");
      out.write("\r\n");

    char mark = '"';
    String strForm = "<form action= " + mark + "/shoppingCart" + mark +" method = " + mark + "post"+ mark + ">";

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<ul>\r\n");

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


      out.write("\r\n");
      out.write("</ul>\r\n");
      out.write("<br>\r\n");
      out.write("<a href = \"http://localhost:8080/\"> Continue Shopping </a>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
