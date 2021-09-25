package controller;

        import model.DBManager;
        import model.entity.Orders;
        import javax.servlet.RequestDispatcher;
        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.util.List;

/**
 * Servlet for creating table with all orders,
 * order by developmentDESC
 * works on manager's cabinet page
 */
@WebServlet(
        name = "/allOrdersSelectByDevDESCServlet",
        urlPatterns = "/allOrdersSelectByDevDESCServlet"
)
public class allOrdersSelectByDevDESCServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager dbManager = DBManager.getInstance();
        List<Orders> ListOrders = dbManager.OrdersListOrderByDevDESC();
        req.setAttribute("ListOrders", ListOrders);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("managerCabinet.jsp");
        requestDispatcher.forward(req, resp);
    }
}