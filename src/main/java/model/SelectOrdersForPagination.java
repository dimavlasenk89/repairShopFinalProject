package model;

import model.entity.Orders;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static controller.Constants.SELECT_ORDERS_FOR_PAGINATION;
import static controller.Constants.SELECT_ROWS_ORDERS_FOR_PAGINATION;

public class SelectOrdersForPagination {
    public int noOfRecords;
    public int selectOrderCount (int begin, int end) {
        Orders orders = null;
        // Step 1: Establishing a Connection
        DBManager dbManager = DBManager.getInstance();
        try (Connection connection = dbManager.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDERS_FOR_PAGINATION, Statement.RETURN_GENERATED_KEYS)) {
            int k = 1;
            preparedStatement.setInt(k++, begin);
            preparedStatement.setInt(k++, end);
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
            rs.close();

            rs = preparedStatement.executeQuery(SELECT_ROWS_ORDERS_FOR_PAGINATION);
            if(rs.next())
                noOfRecords = rs.getInt(1);
        } catch (SQLException e) {
            Logger.getLogger("log").log(Level.SEVERE, "Something went wrong in showCustomersServlet");
        }
        return noOfRecords;
    }
}
