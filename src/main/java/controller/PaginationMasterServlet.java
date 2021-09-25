package controller;

        import java.io.IOException;
        import java.util.List;
        import javax.servlet.RequestDispatcher;
        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import model.DBManager;
        import model.SelectOrdersForPagination;
        import model.entity.Orders;

/**
 * Servlet for pagination on master's page
 */
@WebServlet(
        name = "/PaginationMasterServlet",
        urlPatterns = "/PaginationMasterServlet"
)
public class PaginationMasterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PaginationMasterServlet() {
        super();
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        int page = 1;
        int recordsPerPage = 5;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        SelectOrdersForPagination sekForP = new SelectOrdersForPagination();
        DBManager dbManager = DBManager.getInstance();
        List<Orders>  ListOrders = dbManager.OrdersListByPagination((page-1)*recordsPerPage,
                recordsPerPage);
        int noOfRecords = sekForP.selectOrderCount((page-1)*recordsPerPage,
                recordsPerPage);
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        request.setAttribute("ordersList", ListOrders);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        RequestDispatcher view = request.getRequestDispatcher("masterCabinet.jsp");
        view.forward(request, response);
    }
}