package controller;

        import model.updateBillByManager;
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
        name = "/updateBillServlet",
        urlPatterns = "/updateBillServlet"
)
public class updateBillServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String popUp = req.getParameter("money");
        String customerId = req.getParameter("idInRow3");

//        if ((orderPrice != null) && (orderPrice != "")) {

            int money = parseInt(popUp);
            int id = parseInt(customerId);
            updateBillByManager updBill = new updateBillByManager();
            updBill.updateBill(money, id);
            RequestDispatcher requestDispatcher1 = req.getRequestDispatcher("managerCabinet.jsp");
            requestDispatcher1.forward(req, resp);

//        } else {
//            RequestDispatcher requestDispatcher2 = req.getRequestDispatcher("managerCabinet.jsp");
//            requestDispatcher2.forward(req, resp);
//        }

    }
}