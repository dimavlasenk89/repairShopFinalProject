package controller;

import model.DBManager;
import model.entity.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static controller.Constants.*;

/**
 * Servlet for entry to customer's cabinet,
 * which check's customer's login and password
 */
@WebServlet(
        name = "/allCustomersServlet",
        urlPatterns = "/allCustomersServlet"
)
public class allCustomersServlet extends HttpServlet {
    String cLogin;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("cLogin");
        session.removeAttribute("cBill");
        String cLoginString = req.getParameter(USER_LOGIN_STRING);
        String managerPasswordString = req.getParameter(USER_PASSWORD_STRING);

        String customerLogin = (String) session.getAttribute("cLogin");
        if (customerLogin == null) {
            customerLogin = cLoginString;
        }
        Customer cus = selectCustomerByLogin(customerLogin);
        int customerBill = cus.getBill();
        String cBill = "Ваш рахунок " + customerBill + " $";
        session.setAttribute("cLogin", customerLogin);
        session.setAttribute("cBill", cBill);
        if (cus != null) {
            cLogin = cus.getLogin();
        }         else {
            req.setAttribute("errorAccessMessage", "невірний логін");
            RequestDispatcher view2 = req.getRequestDispatcher("signInPage.jsp");
            view2.forward(req, resp);
        }
        String adminPassword = cus.getPassword();
        if (cLogin.equals(cLoginString)) {
            if (cLogin.equals(cLoginString) && (adminPassword.equals(managerPasswordString))) {
                req.setAttribute("congratulations", cLoginString);
                req.setAttribute("bill", cBill);
                RequestDispatcher view = req.getRequestDispatcher("userCabinet.jsp");
                view.forward(req, resp);
            }
            else {
                req.setAttribute("errorAccessMessage", "невірний пароль");
                RequestDispatcher view2 = req.getRequestDispatcher("signInPage.jsp");
                view2.forward(req, resp);
            }
        }
    }
    public Customer selectCustomerByLogin(String login) {
        Customer customer  = null;
        // Step 1: Establishing a Connection
        DBManager dbManager = DBManager.getInstance();
        try (Connection conn = dbManager.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = conn.prepareStatement(SELECT_CUSTOMER_BY_LOGIN, Statement.RETURN_GENERATED_KEYS)) {
            int k = 1;
            preparedStatement.setString(k++, login);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                int bill = rs.getInt("bill");
                String customerLogin = rs.getString("login");
                String password = rs.getString("password");
                customer = new Customer(id, bill, customerLogin, password);
            }
        } catch (SQLException e) {
            Logger.getLogger("logs").log(Level.SEVERE, "Something went wrong in allCustomersServlet");
        }
        return customer;
    }
}

