package controller;

        import model.updateBillByManager;

        import javax.servlet.RequestDispatcher;
        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import static java.lang.Integer.parseInt;

/**
 * Servlet for top up customer's bill on table with all customers,
 * works on manager's cabinet page
 */
@WebServlet(
        name = "/updateBillServlet",
        urlPatterns = "/updateBillServlet"
)
public class updateBillServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String popUp = req.getParameter("money");
        String customerId = req.getParameter("idInRow3");
            int money = parseInt(popUp);
            int id = parseInt(customerId);
            updateBillByManager updBill = new updateBillByManager();
            updBill.updateBill(money, id);
            RequestDispatcher requestDispatcher1 = req.getRequestDispatcher("managerCabinet.jsp");
            requestDispatcher1.forward(req, resp);
    }
}