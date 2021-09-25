package model;

import model.entity.Customer;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static controller.Constants.*;
/**
 * Class for payment from customer's bill,
 * works with PaymentServlet
 */
public class Payment {
    public int selectBill(String login) {
        Customer customer  = null;
        // Step 1: Establishing a Connection
        DBManager dbManager = DBManager.getInstance();
        try (Connection conn = dbManager.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = conn.prepareStatement(SELECT_BILL_BY_LOGIN, Statement.RETURN_GENERATED_KEYS)) {
            int k = 1;
            preparedStatement.setString(k++, login);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int bill = rs.getInt("bill");
                customer = new Customer(bill);
            }
        } catch (SQLException e) {
            Logger.getLogger("selectBillLog").log(Level.SEVERE, "Something went wrong in selectBill method");
        }
        return customer.getBill();
    }
    public void updateBill(int money, String login) {
        // Step 1: Establishing a Connection
        DBManager dbManager = DBManager.getInstance();
        try (Connection conn = dbManager.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = conn.prepareStatement(BILL_UPDATE)) {
            int k = 1;
            preparedStatement.setInt(k++, money);
            preparedStatement.setString(k++, login);
            // Step 3: Execute the updated query
            preparedStatement.executeUpdate();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            Logger.getLogger("logManagerBillUpdate").log(Level.SEVERE, "Something went wrong while bill updating");
        }
    }

}
