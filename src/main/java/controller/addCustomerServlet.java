package controller;

import model.AddCustomer;
import model.entity.Customer;
import model.exceptions.DBException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static controller.Constants.USER_LOGIN_STRING;
import static controller.Constants.USER_PASSWORD_STRING;

/**
 * Servlet for sign on page,
 * which adds new customer to database,
 * by using logic method from model class "AddCustomer"
 */
@WebServlet(
        name = "/addCustomerServlet",
        urlPatterns = "/addCustomerServlet"
)
public class addCustomerServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        session.removeAttribute("cLogin");
        String userloginString = req.getParameter(USER_LOGIN_STRING);
        String userPasswordString = req.getParameter(USER_PASSWORD_STRING);

        String customerLogin = (String) session.getAttribute("cLogin");
        if (customerLogin == null) {
            customerLogin = userloginString;
        }
        session.setAttribute("cLogin", customerLogin);

        try {
            Customer customer = new Customer();
            customer.setBill(0);
            if (!(userloginString.equals(""))) {
                customer.setLogin(userloginString);
            }
            if (!(userPasswordString.equals(""))) {
                customer.setPassword(userPasswordString);
            }
            AddCustomer addCustomer = new AddCustomer();
            addCustomer.insertCustomerModel(customer);
            req.setAttribute("congratulations", userloginString);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("userCabinet.jsp");
            requestDispatcher.forward(req, resp);
        } catch (DBException e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", e.getMessage());
            RequestDispatcher view = req.getRequestDispatcher("error.jsp");
            view.forward(req, resp);
            System.out.println(e.getMessage());
        }
    }
}
