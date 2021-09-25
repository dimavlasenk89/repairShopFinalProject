package controller;

        import model.Payment;
        import model.updatePaymentStatus;

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
 * Servlet for payment from customer's bill,
 * works on customer's cabinet page
 */
@WebServlet(
        name = "/PaymentServlet",
        urlPatterns = "/PaymentServlet"
)
public class PaymentServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        String str = (String) session.getAttribute("cLogin");
        String ordersPrice = req.getParameter("ordersPrice1");
        String idInRow = req.getParameter("idInRow4");
        String str = req.getParameter("customerLogin1");
        int price = parseInt(ordersPrice);
        int id = parseInt(idInRow);
        Payment payment = new Payment();
        updatePaymentStatus updPaid = new updatePaymentStatus();
        int billBefore = payment.selectBill(str);
        if (price == 0) {
            req.setAttribute("notEnoughMoney", "Ціна ще не призначена");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("userCabinet.jsp");
            requestDispatcher.forward(req, resp);
        }
        if ((billBefore < price) && (price != 0)) {
                req.setAttribute("notEnoughMoney", "Недостатньо грошей");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("userCabinet.jsp");
                requestDispatcher.forward(req, resp);
            }
        if ((billBefore > price) && (price != 0)) {
                int billAfter = billBefore - price;
                payment.updateBill(billAfter, str);
                updPaid.isPaid(id);
                req.setAttribute("notEnoughMoney", "Транзакція успішна");
                RequestDispatcher requestDispatcher1 = req.getRequestDispatcher("userCabinet.jsp");
                requestDispatcher1.forward(req, resp);
            }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("userCabinet.jsp");
        requestDispatcher.forward(req, resp);
    }
}