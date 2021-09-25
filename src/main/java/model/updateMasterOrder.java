package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static controller.Constants.MASTER_DONE_ORDER;
import static controller.Constants.MASTER_UPDATE_ORDER;

public class updateMasterOrder {
    public void updateMasterDev (String login, int id) {
        // Step 1: Establishing a Connection
        DBManager dbManager = DBManager.getInstance();
        try (Connection conn = dbManager.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = conn.prepareStatement(MASTER_UPDATE_ORDER, ResultSet.CONCUR_UPDATABLE)) {
            int k = 1;
            preparedStatement.setString(k++, login);
            preparedStatement.setInt(k++, id);
            // Step 3: Execute the updated query
            preparedStatement.executeUpdate();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            Logger.getLogger("logMaster").log(Level.SEVERE, "Something went wrong while order updating by master");
        }
    }
    public void updateMasterDone (String login, int id) {
        // Step 1: Establishing a Connection
        DBManager dbManag = DBManager.getInstance();
        try (Connection con = dbManag.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement psmt = con.prepareStatement(MASTER_DONE_ORDER)) {
            int k = 1;
            psmt.setString(k++, login);
            psmt.setInt(k++, id);
            // Step 3: Execute the updated query
            psmt.executeUpdate();
            con.setAutoCommit(true);
        } catch (SQLException e) {
            Logger.getLogger("logMaster").log(Level.SEVERE, "Something went wrong in masterStatusServlet");
        }
    }
}
