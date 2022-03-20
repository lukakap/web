package store;

import javax.servlet.ServletContextEvent;

public class ServletContextListener implements javax.servlet.ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        sqlProductsDAO store = new sqlProductsDAO();
        servletContextEvent.getServletContext().setAttribute("store",store);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        contextDestroyed(servletContextEvent);
    }
}
