package controller;

import model.AddOrder;
import model.entity.Customer;
import model.entity.Orders;
import model.exceptions.DBException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Servlet for creating new order by a particular customer,
 * works on user's cabinet page,
 * in case of success will reference to service page,
 * for implementing pattern PRG (Post/Redirect/Get)
 */
@WebServlet(
        name = "/newOrderServlet",
        urlPatterns = "/newOrderServlet"
)

public class newOrderServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String str = (String) session.getAttribute("cLogin");
        try {
        Orders orders = new Orders();
        Date date = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String ordersDate = sdf.format(calendar.getTime());

        String[] checkBoxValues = req.getParameterValues("wheelsEngineElectricity");

            orders.setCustomerLogin(str);
            orders.setMasterLogin(null);
            orders.setCreatedAt(ordersDate);
            orders.setInDevelopment(false);
            orders.setDone(false);
            orders.setWaitingForPayment(true);
            orders.setPaid(false);
            orders.setCanceled(false);
            orders.setOrdersPrice(0);
            if (checkBoxValues != null) {
            for(String checkBoxValue: checkBoxValues){
                if (checkBoxValue.equals("option2")) {
                    orders.setCheckEngine(true);
                }
                if (checkBoxValue.equals("option3")) {
                    orders.setCheckElectricity(true);
                }
                if (checkBoxValue.equals("option1")) {
                    orders.setCheckWheels(true);
                }
            }
                orders.setCarType(req.getParameter("carType"));
                orders.setMasterReference(null);
                AddOrder addOrder = new AddOrder();
                addOrder.AddOrderModel(orders);
                req.setAttribute("successOrder", "Вітаємо! Ваша заявка прийнята!");
                req.setAttribute("back", "Назад");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("services.jsp");
                requestDispatcher.forward(req, resp);
        } else {
                req.setAttribute("errorFillOrder", "оберіть послугу");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("userCabinet.jsp");
                requestDispatcher.forward(req, resp);
            }
        } catch (DBException e) {
            e.printStackTrace();
            req.setAttribute("AddOrderError", "або, можливо, виникла помилка при створенні замовлення");
            RequestDispatcher view = req.getRequestDispatcher("error.jsp");
            view.forward(req, resp);
        }
    }
}

