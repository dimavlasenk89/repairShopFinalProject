package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static controller.Constants.PRICE_UPDATE_ORDER;

public class updatePrice {
    public void updatePriceByManager (int price, int id) {
        // Step 1: Establishing a Connection
        DBManager dbManager = DBManager.getInstance();
        try (Connection conn = dbManager.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = conn.prepareStatement(PRICE_UPDATE_ORDER)) {
            int k = 1;
            preparedStatement.setInt(k++, price);
            preparedStatement.setInt(k++, id);
            // Step 3: Execute the updated query
            preparedStatement.executeUpdate();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            Logger.getLogger("logManager").log(Level.SEVERE, "Something went wrong while price updating");
        }
    }
}
