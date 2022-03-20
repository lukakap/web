package store;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class shoppingCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("WEB-INF/shoppingCart.jsp").forward(httpServletRequest,httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        Cart cart = getShoppingCart(httpServletRequest);
        sqlProductsDAO store = getStore(httpServletRequest);
        if(httpServletRequest.getParameter("submitAddToCart") != null){
            String symbolOfProduct = httpServletRequest.getParameter("hidden");
            Product product = store.getProductByID(symbolOfProduct);
            cart.incrementProductNumber(product);
        } else {
            HashMap<Product, Integer> products = cart.returnCart();
            ArrayList<Product> toDelete = new ArrayList<>();
            for (Product product : products.keySet()) {
                if (httpServletRequest.getParameter(product.getName()) != null) {
                    String num = httpServletRequest.getParameter(product.getName());
                    if(!num.equals("")) {
                        Integer newNum = Integer.valueOf(num);
                        if (newNum == 0) toDelete.add(product);
                        else cart.addElement(product, newNum);
                    }
                }
            }

            for (Product product : toDelete) {
                cart.addElement(product, 0);
            }
        }

        httpServletRequest.getRequestDispatcher("WEB-INF/shoppingCart.jsp").forward(httpServletRequest,httpServletResponse);
    }

//String hiddenInput = "<input type =" +mark + "hidden" + mark + " name= " + mark + name + mark +"id=" + mark + name + mark +" value=" + mark + symbol + mark + ">";

    private Cart getShoppingCart(HttpServletRequest req){
        HttpSession mySession = req.getSession();
        Cart cart = (Cart) mySession.getAttribute("shoppingCart");
        return cart;
    }

    private sqlProductsDAO getStore(HttpServletRequest request){
        ServletContext ctx = request.getServletContext();
        sqlProductsDAO store = (sqlProductsDAO) ctx.getAttribute("store");
        return store;
    }

    // String input = "<input name = " + mark + "productID" + mark + " type="+mark + "hidden" + mark + "value=" + mark + num + mark+">";
}
