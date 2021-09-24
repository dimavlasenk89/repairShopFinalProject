package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static controller.Constants.*;

public class updatePaymentStatus {
    public void isWaiting (int id) {
        // Step 1: Establishing a Connection
        DBManager dbManager = DBManager.getInstance();
        try (Connection conn = dbManager.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_PAYMENT_STATUS)) {
            int k = 1;
            preparedStatement.setInt(k++, id);
            // Step 3: Execute the updated query
            preparedStatement.executeUpdate();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            Logger.getLogger("logManager1").log(Level.SEVERE, "Something went wrong while order updating by manager");
        }
    }
    public void isPaid (int id) {
        // Step 1: Establishing a Connection
        DBManager dbManag = DBManager.getInstance();
        try (Connection con = dbManag.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement psmt = con.prepareStatement(UPDATE_PAYMENT_STATUS_PAID)) {
            int k = 1;
            psmt.setInt(k++, id);
            // Step 3: Execute the updated query
            psmt.executeUpdate();
            con.setAutoCommit(true);
        } catch (SQLException e) {
            Logger.getLogger("logManager2").log(Level.SEVERE, "Something went wrong while order updating by manager");
        }
    }
    public void isCanceled (int id) {
        // Step 1: Establishing a Connection
        DBManager dbManag = DBManager.getInstance();
        try (Connection con = dbManag.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement psmt = con.prepareStatement(UPDATE_PAYMENT_STATUS_CANCELED)) {
            int k = 1;
            psmt.setInt(k++, id);
            // Step 3: Execute the updated query
            psmt.executeUpdate();
            con.setAutoCommit(true);
        } catch (SQLException e) {
            Logger.getLogger("logManager3").log(Level.SEVERE, "Something went wrong while order updating by manager");
        }
    }
}
