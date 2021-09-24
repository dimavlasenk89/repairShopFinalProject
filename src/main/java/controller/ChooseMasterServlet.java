package controller;

        import model.updateMaster;
        import javax.servlet.RequestDispatcher;
        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import static java.lang.Integer.parseInt;

/**
 * Servlet for choose master on table with all orders,
 * works on manager's cabinet page
 */
@WebServlet(
        name = "/ChooseMasterServlet",
        urlPatterns = "/ChooseMasterServlet"
)
public class ChooseMasterServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderMaster = req.getParameter("masterLogin");
        String orderId = req.getParameter("idInRow2");
        if (orderMaster != null) {
            int id = parseInt(orderId);
            updateMaster updMr = new updateMaster();
            updMr.updateMasterByManager(orderMaster, id);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("managerCabinet.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}