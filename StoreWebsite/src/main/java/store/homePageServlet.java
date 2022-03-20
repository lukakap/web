package store;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class homePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        sqlProductsDAO store = getStore(httpServletRequest);
        List<Product> listOfProducts = store.getAll();
        httpServletRequest.setAttribute("productsList",listOfProducts);
        httpServletRequest.getRequestDispatcher("WEB-INF/homePage.jsp").forward(httpServletRequest,httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        doGet(httpServletRequest,httpServletResponse);
    }

    private sqlProductsDAO getStore(HttpServletRequest request){
        ServletContext ctx = request.getServletContext();
        sqlProductsDAO store = (sqlProductsDAO) ctx.getAttribute("store");
        return store;
    }
}
