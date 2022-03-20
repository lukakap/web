package store;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

public class SessionListener implements HttpSessionListener {


    @Override
    public void sessionCreated(HttpSessionEvent e) {
        Cart cart = new Cart();
        e.getSession().setAttribute("shoppingCart",cart);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        sessionDestroyed(httpSessionEvent);
    }


}
