package store;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

public class showProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        sqlProductsDAO store = getStore(httpServletRequest);
        Product product = store.getProductByID(httpServletRequest.getParameter("id"));
        String productName = product.getName();
        double price = product.getPrice();
        String symbol = product.getProductID();
        String picUrl = product.getImageFile();
        httpServletRequest.setAttribute("productName",productName);
        httpServletRequest.setAttribute("productPrice",price);
        httpServletRequest.setAttribute("productPicUrl",picUrl);
        httpServletRequest.setAttribute("productSymbol",symbol);
        httpServletRequest.getRequestDispatcher("WEB-INF/showProduct.jsp").forward(httpServletRequest,httpServletResponse);
    }


    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

    }

    private sqlProductsDAO getStore(HttpServletRequest request){
        ServletContext ctx = request.getServletContext();
        sqlProductsDAO store = (sqlProductsDAO) ctx.getAttribute("store");
        return store;
    }

    private Cart getShoppingCart(HttpServletRequest req){
        HttpSession mySession = req.getSession();
        Cart cart = (Cart) mySession.getAttribute("shoppingCart");
        return cart;
    }
}
