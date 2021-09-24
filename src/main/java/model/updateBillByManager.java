package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static controller.Constants.BILL_UPDATE_CUSTOMER;

public class updateBillByManager {
   public void updateBill(int money, int id) {
       // Step 1: Establishing a Connection
       DBManager dbManager = DBManager.getInstance();
       try (Connection conn = dbManager.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = conn.prepareStatement(BILL_UPDATE_CUSTOMER)) {
           int k = 1;
           preparedStatement.setInt(k++, money);
           preparedStatement.setInt(k++, id);
           // Step 3: Execute the updated query
           preparedStatement.executeUpdate();
           conn.setAutoCommit(true);
       } catch (SQLException e) {
           Logger.getLogger("logManagerBillUpdate").log(Level.SEVERE, "Something went wrong while bill updating");
       }
    }
}
