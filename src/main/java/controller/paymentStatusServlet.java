package controller;

import model.updatePaymentStatus;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;

/**
 * Servlet for updating payment status on table with all orders,
 * works on manager's cabinet page
 */
@WebServlet(
        name = "paymentStatusServlet",
        urlPatterns = "/paymentStatusServlet"
)
public class paymentStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userTypeString = req.getParameter("paymentSelect");
        updatePaymentStatus uPaySt = new updatePaymentStatus();
        String orderId = req.getParameter("idInRow3");
        int id = parseInt(orderId);
        if (userTypeString.equals("option1")) {
            uPaySt.isWaiting(id);
        }
        if (userTypeString.equals("option2")) {
            uPaySt.isPaid(id);
        }
        if (userTypeString.equals("option3")) {
            uPaySt.isCanceled(id);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("managerCabinet.jsp");
        requestDispatcher.forward(req, resp);
    }
}
