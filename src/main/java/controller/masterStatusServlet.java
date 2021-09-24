package controller;

import model.updateMasterOrder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.lang.Integer.parseInt;

/**
 * Servlet for updating table with all orders,
 * works on master's cabinet page
 */
@WebServlet(
        name = "masterStatusServlet",
        urlPatterns = "/masterStatusServlet"
)
public class masterStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String str = (String) session.getAttribute("masterLogin");
        String orderId = req.getParameter("orderId");
        if (orderId.equals("")) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("masterCabinet.jsp");
            requestDispatcher.forward(req, resp);
        }
        int id = parseInt(orderId);
        String userTypeString = req.getParameter("Type");
        updateMasterOrder updMO = new updateMasterOrder();
        if (userTypeString == null) {
            req.setAttribute("master", "Оберіть статус замовлення");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("masterCabinet.jsp");
            requestDispatcher.forward(req, resp);
        }
        if (userTypeString.equals("option1")) {
            updMO.updateMasterDev(str, id);
        }
        if (userTypeString.equals("option2")) {
            updMO.updateMasterDone(str, id);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("masterCabinet.jsp");
        requestDispatcher.forward(req, resp);
    }
    }
