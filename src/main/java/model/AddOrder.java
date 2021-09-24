package model;

import model.entity.Orders;
import model.exceptions.DBException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddOrder {

    //logic method
    public void AddOrderModel (Orders order) throws DBException {
        Connection con = null;
        DBManager dbManager = DBManager.getInstance();
        try {
            con = DBManager.getConnection();
            dbManager.addOrder(con, order);
            con.commit();
        } catch (SQLException ex) {
            Logger.getLogger("add order logger").log(Level.SEVERE, "SQLException");
            rollback(con);
            throw new DBException("виникла помилка при створенні замовлення", ex);
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
