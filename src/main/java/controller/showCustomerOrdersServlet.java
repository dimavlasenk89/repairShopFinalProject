package controller;

import model.DBManager;
import model.entity.Orders;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static controller.Constants.*;

/**
 * Servlet for creating table with all orders created by a particular customer,
 * works on user's cabinet page
 */
@WebServlet(
        name = "/showCustomerOrdersServlet",
        urlPatterns = "/showCustomerOrdersServlet"
)

public class showCustomerOrdersServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String str = (String) session.getAttribute("cLogin");
        List<Integer> ListIds;
        ListIds = IdList(str);
        List<Orders> ListOrdersByCustomer = new ArrayList<>();
        ListIds.forEach(numberId -> ListOrdersByCustomer.add(selectOrder(numberId)));
        req.setAttribute("ListOrdersByCustomer", ListOrdersByCustomer);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("userCabinet.jsp");
        requestDispatcher.forward(req, resp);
    }
    //select order by particular ID
    public Orders selectOrder (int idi) {
        Orders orders = null;
        // Step 1: Establishing a Connection
        DBManager dbManager = DBManager.getInstance();
        try (Connection connection = dbManager.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_BY_ID, Statement.RETURN_GENERATED_KEYS)) {
            int k = 1;
            preparedStatement.setInt(k++, idi);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                boolean isInDevelopment = rs.getBoolean("is_in_development");
                boolean isDone = rs.getBoolean("is_done");
                boolean isPaid = rs.getBoolean("is_paid");
                boolean isWaitingForPayment = rs.getBoolean("is_waiting_for_payment");
                boolean isCanceled = rs.getBoolean("is_canceled");
                boolean isCheckEngine = rs.getBoolean("is_CheckEngine");
                boolean isCheckElectricity = rs.getBoolean("is_CheckElectricity");
                boolean isCheckWheels = rs.getBoolean("is_CheckWheels");
                int id = rs.getInt("Id");
                int ordersPrice = rs.getInt("ordersPrice");
                String customerLogin = rs.getString("CustomerLogin");
                String masterLogin = rs.getString("masterLogin");
                String createdAt = rs.getString("createdAt");
                String carType = rs.getString("car_type");
                String masterReference = rs.getString("car_type");
                orders = new Orders(isInDevelopment, isDone, isPaid, isWaitingForPayment, isCanceled, isCheckEngine,
                        isCheckElectricity, isCheckWheels, id, ordersPrice, customerLogin, masterLogin, createdAt, carType, masterReference);
            }
        } catch (SQLException e) {
            Logger.getLogger("log").log(Level.SEVERE, "Something went wrong in showCustomersServlet");
        }
        return orders;
    }

    // returns list of orders ID's which was created by person with particular login
    public List<Integer> IdList(String login) {
        List<Integer> ListId = new ArrayList<>();
        int userOrdersId;
        String allUserOrders1 = SELECT_ALL_ORDERS_BY_LOGIN + "'" + login + "'";
        DBManager dbManager = DBManager.getInstance();
        try (Connection con = dbManager.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(allUserOrders1)) {
            while (rs.next()) {
                userOrdersId = rs.getInt(1);
                ListId.add(userOrdersId);
            }
        } catch (SQLException e) {
            Logger.getLogger("logg").log(Level.SEVERE, "Something went wrong in showCustomersServlet1");
        }
        return ListId;
    }
}
