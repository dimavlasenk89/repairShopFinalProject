package controller;

import model.updatePrice;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static java.lang.Integer.parseInt;

/**
 * Servlet for managing price on table with all orders,
 * works on manager's cabinet page
 */
@WebServlet(
        name = "/ManageAllOrdersServlet",
        urlPatterns = "/ManageAllOrdersServlet"
)
public class ManageAllOrdersServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderPrice = req.getParameter("price");
        String orderId = req.getParameter("idInRow");
        if ((orderPrice != null) && (orderPrice != "")) {
            int price = parseInt(orderPrice);
            int id = parseInt(orderId);
            updatePrice updPr = new updatePrice();
            updPr.updatePriceByManager(price, id);
            RequestDispatcher requestDispatcher1 = req.getRequestDispatcher("managerCabinet.jsp");
            requestDispatcher1.forward(req, resp);
        } else {
            RequestDispatcher requestDispatcher2 = req.getRequestDispatcher("managerCabinet.jsp");
            requestDispatcher2.forward(req, resp);
        }
    }
}
