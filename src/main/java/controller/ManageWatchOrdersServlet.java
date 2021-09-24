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
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static controller.Constants.*;

/**
 * Servlet for watching table with orders which works with particular master,
 * or particular status,
 * works on manager's cabinet page
 */
@WebServlet(
        name = "/ManageWatchOrdersServlet",
        urlPatterns = "/ManageWatchOrdersServlet"
)
public class ManageWatchOrdersServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = req.getParameter("master");
        String[] checkBoxValues = req.getParameterValues("orderStatus");
        if (!(str.equals(""))) {
            List<Integer> ListIds;
            ListIds = IdList(str);
            List<Orders> ListOrdersByMaster = new ArrayList<>();
            ListIds.forEach(numberId -> ListOrdersByMaster.add(selectOrder(numberId)));
            req.setAttribute("ListOrders", ListOrdersByMaster);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("managerCabinet.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            for(String checkBoxValue: checkBoxValues){
                if (checkBoxValue.equals("option1")) {
                    List<Integer> ListIds;
                    ListIds = IdListWaitingForPayment();
                    List<Orders> ListOrdersByPaymentStatus = new ArrayList<>();
                    ListIds.forEach(numberId -> ListOrdersByPaymentStatus.add(selectOrder(numberId)));
                    req.setAttribute("ListOrders", ListOrdersByPaymentStatus);
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("managerCabinet.jsp");
                    requestDispatcher.forward(req, resp);
                }
                if (checkBoxValue.equals("option2")) {
                    List<Integer> ListIds;
                    ListIds = IdListPayment();
                    List<Orders> ListOrdersByPaymentStatus = new ArrayList<>();
                    ListIds.forEach(numberId -> ListOrdersByPaymentStatus.add(selectOrder(numberId)));
                    req.setAttribute("ListOrders", ListOrdersByPaymentStatus);
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("managerCabinet.jsp");
                    requestDispatcher.forward(req, resp);
                }
                if (checkBoxValue.equals("option3")) {
                    List<Integer> ListIds;
                    ListIds = IdListCanceled();
                    List<Orders> ListOrdersByPaymentStatus = new ArrayList<>();
                    ListIds.forEach(numberId -> ListOrdersByPaymentStatus.add(selectOrder(numberId)));
                    req.setAttribute("ListOrders", ListOrdersByPaymentStatus);
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("managerCabinet.jsp");
                    requestDispatcher.forward(req, resp);
                }
            }
        }
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
                String masterReference = rs.getString("master_reference");
                orders = new Orders(isInDevelopment, isDone, isPaid, isWaitingForPayment, isCanceled, isCheckEngine,
                        isCheckElectricity, isCheckWheels, id, ordersPrice, customerLogin, masterLogin, createdAt, carType, masterReference);
            }
        } catch (SQLException e) {
            Logger.getLogger("log").log(Level.SEVERE, "Something went wrong in ManageWatchOrdersServlet1");
        }
        return orders;
    }

    // returns list of orders ID's which was work's with particular master
    public List<Integer> IdList(String masterLogin) {
        List<Integer> ListId = new ArrayList<>();
        int masterOrdersId;
        String allMasterOrders = SELECT_ALL_ORDERS_BY_MASTER_LOGIN + "'" + masterLogin + "'";
        try (Connection con = DBManager.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(allMasterOrders)) {
            while (rs.next()) {
                masterOrdersId = rs.getInt(1);
                ListId.add(masterOrdersId);
            }
        } catch (SQLException e) {
            Logger.getLogger("logg").log(Level.SEVERE, "Something went wrong in ManageWatchOrdersServlet2");
        }
        return ListId;
    }
    // returns list of orders ID's which has positive is_paid status
    public List<Integer> IdListPayment() {
        List<Integer> ListId = new ArrayList<>();
        int masterOrdersId;
        try (Connection con = DBManager.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL_ORDERS_BY_PAYMENT_STATUS)) {
            while (rs.next()) {
                masterOrdersId = rs.getInt(1);
                ListId.add(masterOrdersId);
            }
        } catch (SQLException e) {
            Logger.getLogger("logger").log(Level.SEVERE, "Something went wrong in ManageWatchOrdersServlet3");
        }
        return ListId;
    }
    // returns list of orders ID's which has positive is_waiting_for_payment status
    public List<Integer> IdListWaitingForPayment() {
        List<Integer> ListId = new ArrayList<>();
        int masterOrdersId;
        try (Connection con = DBManager.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL_ORDERS_BY_WAITING_FOR_PAYMENT_STATUS)) {
            while (rs.next()) {
                masterOrdersId = rs.getInt(1);
                ListId.add(masterOrdersId);
            }
        } catch (SQLException e) {
            Logger.getLogger("logger1").log(Level.SEVERE, "Something went wrong in ManageWatchOrdersServlet4");
        }
        return ListId;
    }
    // returns list of orders ID's which has positive is_canceled status
    public List<Integer> IdListCanceled() {
        List<Integer> ListId = new ArrayList<>();
        int masterOrdersId;
        try (Connection con = DBManager.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL_ORDERS_BY_CANCELED_STATUS)) {
            while (rs.next()) {
                masterOrdersId = rs.getInt(1);
                ListId.add(masterOrdersId);
            }
        } catch (SQLException e) {
            Logger.getLogger("logger2").log(Level.SEVERE, "Something went wrong in ManageWatchOrdersServlet5");
        }
        return ListId;
    }
}

