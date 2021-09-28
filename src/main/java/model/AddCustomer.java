package model;

import model.entity.Customer;
import model.exceptions.DBException;
import org.apache.log4j.LogManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddCustomer {
    public static org.apache.log4j.Logger LOG = LogManager.getLogger(AddCustomer.class);
    //logic method
    public void insertCustomerModel (Customer customer) throws DBException {
        Connection con = null;
        DBManager dbManager = DBManager.getInstance();
        try {
            con = dbManager.getConnection();
            dbManager.insertCustomer(con, customer);
            con.commit();
        } catch (SQLException ex) {
            LOG.error("Something went wrong while insert customer");
            Logger.getLogger("logger").log(Level.SEVERE, "SQLException");
            rollback(con);
            throw new DBException("або зверніться до служби підтримки", ex);
        }
    }

    private static void rollback(Connection connection) {
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
