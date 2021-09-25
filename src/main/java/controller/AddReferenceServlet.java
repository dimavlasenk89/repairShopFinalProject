package controller;

        import model.addReference;
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
 * Servlet for composing reference about master on table with all orders,
 * works on customer's cabinet page
 */
@WebServlet(
        name = "/AddReferenceServlet",
        urlPatterns = "/AddReferenceServlet"
)
public class AddReferenceServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idOrd = req.getParameter("id");
        String refOrd = req.getParameter("Textarea");
        int id = parseInt(idOrd);
        addReference addRef = new addReference();
        if (!(refOrd.equals(""))){
            addRef.updateReference(refOrd, id);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("userCabinet.jsp");
            requestDispatcher.forward(req, resp);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("userCabinet.jsp");
        requestDispatcher.forward(req, resp);
    }
}