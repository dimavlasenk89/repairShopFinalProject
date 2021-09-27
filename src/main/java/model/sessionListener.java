package model;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class sessionListener implements HttpSessionListener {
    static int total = 0;
    static int current = 0;
    public static int totalCount() {
        return total;
    }
    public static int currentCount() {
        return current;
    }
    @Override
    public void sessionCreated(HttpSessionEvent se) {
       total++;
       current++;
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        current--;
    }
}
