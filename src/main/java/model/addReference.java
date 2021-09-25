package model;

        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.SQLException;
        import java.util.logging.Level;
        import java.util.logging.Logger;

        import static controller.Constants.REFERENCE_UPDATE;

public class addReference {
    public void updateReference (String reference, int id) {
        // Step 1: Establishing a Connection
        DBManager dbManager = DBManager.getInstance();
        try (Connection conn = dbManager.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = conn.prepareStatement(REFERENCE_UPDATE)) {
            int k = 1;
            preparedStatement.setString(k++, reference);
            preparedStatement.setInt(k++, id);
            // Step 3: Execute the updated query
            preparedStatement.executeUpdate();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            Logger.getLogger("logManagerReference").log(Level.SEVERE, "Something went wrong while reference updating");
        }
    }
}