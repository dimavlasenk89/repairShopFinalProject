package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static controller.Constants.UPDATE_MASTER_BY_MANAGER;

public class updateMaster {
    public void updateMasterByManager (String orderMaster, int id) {
        // Step 1: Establishing a Connection
        DBManager dbManager = DBManager.getInstance();
        try (Connection conn = dbManager.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_MASTER_BY_MANAGER)) {
            int k = 1;
            preparedStatement.setString(k++, orderMaster);
            preparedStatement.setInt(k++, id);
            // Step 3: Execute the updated query
            preparedStatement.executeUpdate();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            Logger.getLogger("logManager").log(Level.SEVERE, "Something went wrong while master updating");
        }
    }
}
