package model;

import model.entity.Customer;
import model.entity.Orders;
import org.apache.log4j.LogManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static controller.Constants.*;

/**
 * Database manager, which created by using singleton pattern.
 * Filled with low-level methods for getting databases data
 */
public class DBManager {
    public static org.apache.log4j.Logger LOG = LogManager.getLogger(DBManager.class);

    private static DBManager instance;

public static synchronized DBManager getInstance() {
    if (instance == null) {
        instance = new DBManager();
    }
    return instance;
}
private DBManager() {
    try {
        Context initContext = new InitialContext();
        Context envContext = (Context) initContext.lookup("java:/comp/env");
        ds = (DataSource) envContext.lookup("jdbc/TestDB");
    } catch (NamingException ex){
    throw new IllegalStateException("Cannot init DBManager", ex);
    }
}
private DataSource ds;

public Connection getConnection() throws SQLException {
    return ds.getConnection();
}
    //low level method
    public void addOrder (Connection connect, Orders order) throws SQLException{
        PreparedStatement preparedSt = null;
        ResultSet reset = null;
        try {
            preparedSt = connect.prepareStatement(SQL_ADD_NEW_ORDER, Statement.RETURN_GENERATED_KEYS);
            int k = 1;
            preparedSt.setString(k++, order.getCustomerLogin());
            preparedSt.setString(k++, order.getMasterLogin());
            preparedSt.setString(k++, order.getCreatedAt());
            preparedSt.setBoolean(k++, order.isInDevelopment());
            preparedSt.setBoolean(k++, order.isDone());
            preparedSt.setBoolean(k++, order.isWaitingForPayment());
            preparedSt.setBoolean(k++, order.isPaid());
            preparedSt.setBoolean(k++, order.isCanceled());
            preparedSt.setInt(k++, order.getOrdersPrice());
            preparedSt.setBoolean(k++, order.isCheckEngine());
            preparedSt.setBoolean(k++, order.isCheckElectricity());
            preparedSt.setBoolean(k++, order.isCheckWheels());
            preparedSt.setString(k++, order.getCarType());
            preparedSt.setString(k++, order.getMasterReference());
            if (preparedSt.executeUpdate() > 0) {
                reset = preparedSt.getGeneratedKeys();
                if (reset.next()) {
                    order.setId(reset.getInt(1));
                }
            }
        } finally {
            close(reset);
            close(preparedSt);
        }
    }
    //low level method
    public void insertCustomer (Connection con, Customer customer) throws SQLException{
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(SQL_INSERT_CUSTOMER, Statement.RETURN_GENERATED_KEYS);
            int k = 1;
            pstmt.setInt(k++, customer.getBill());
            pstmt.setString(k++, customer.getLogin());
            pstmt.setString(k++, customer.getPassword());
            if (pstmt.executeUpdate() > 0) {
                rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    customer.setId(rs.getInt(1));
                }
            }
        } finally {
            close(rs);
            close(pstmt);
            }
    }
    private static void close (AutoCloseable ac) {
        if (ac != null) {
            try {
                ac.close();
            } catch (Exception e) {
                LOG.error("Something went wrong in close method");
                e.printStackTrace();
            }
        }
    }
    public List<Customer> CustomersList() {
        List<Customer> CustomerList = new ArrayList<>();
        DBManager dbManager = DBManager.getInstance();
        try (Connection connection = dbManager.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(GET_ALL_CUSTOMERS)) {
            while (rs.next()) {
                CustomerList.add(mapCustomer(rs));
            }
        } catch (SQLException e) {
            Logger.getLogger("logger").log(Level.SEVERE, "Something went wrong in AllLogins");
        }
        return CustomerList;
    }
    public Customer mapCustomer(ResultSet rs) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getInt(USER_ID_STRING));
        customer.setLogin(rs.getString(USER_LOGIN_STRING));
        customer.setBill(rs.getInt(USER_BILL_STRING));
        customer.setPassword(rs.getString(USER_PASSWORD_STRING));
        return customer;
    }

    public List<Orders> OrdersList() {
        List<Orders> OrdersList = new ArrayList<>();
        DBManager dbManager = DBManager.getInstance();
        try (Connection connection = dbManager.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(SELECT_ALL_ORDERS)) {
            while (resultSet.next()) {
                OrdersList.add(mapOrders(resultSet));
            }
        } catch (SQLException e) {
            Logger.getLogger("logger").log(Level.SEVERE, "Something went wrong in AllOrders");
        }
        return OrdersList;
    }
    public List<Orders> OrdersListOrderByPriceASC() {
        List<Orders> OrdersListPriceASC = new ArrayList<>();
        DBManager dbManager = DBManager.getInstance();
        try (Connection connection = dbManager.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(SELECT_ALL_ORDERS_ORDER_BY_PRICE_ASC)) {
            while (resultSet.next()) {
                OrdersListPriceASC.add(mapOrders(resultSet));
            }
        } catch (SQLException e) {
            Logger.getLogger("logger1").log(Level.SEVERE, "Something went wrong in AllOrders1");
        }
        return OrdersListPriceASC;
    }
    public List<Orders> OrdersListOrderByPriceDESC() {
        List<Orders> OrdersListPriceDESC = new ArrayList<>();
        DBManager dbManager = DBManager.getInstance();
        try (Connection connection = dbManager.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(SELECT_ALL_ORDERS_ORDER_BY_PRICE_DESC)) {
            while (resultSet.next()) {
                OrdersListPriceDESC.add(mapOrders(resultSet));
            }
        } catch (SQLException e) {
            Logger.getLogger("logger2").log(Level.SEVERE, "Something went wrong in AllOrders2");
        }
        return OrdersListPriceDESC;
    }
    public List<Orders> OrdersListOrderByDataASC() {
        List<Orders> OrdersListDataASC = new ArrayList<>();
        DBManager dbManager = DBManager.getInstance();
        try (Connection connection = dbManager.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(SELECT_ALL_ORDERS_ORDER_BY_DATA_ASC)) {
            while (resultSet.next()) {
                OrdersListDataASC.add(mapOrders(resultSet));
            }
        } catch (SQLException e) {
            Logger.getLogger("logger3").log(Level.SEVERE, "Something went wrong in AllOrders3");
        }
        return OrdersListDataASC;
    }
    public List<Orders> OrdersListOrderByDataDESC() {
        List<Orders> OrdersListDataDESC = new ArrayList<>();
        DBManager dbManager = DBManager.getInstance();
        try (Connection connection = dbManager.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(SELECT_ALL_ORDERS_ORDER_BY_DATA_DESC)) {
            while (resultSet.next()) {
                OrdersListDataDESC.add(mapOrders(resultSet));
            }
        } catch (SQLException e) {
            Logger.getLogger("logger4").log(Level.SEVERE, "Something went wrong in AllOrders4");
        }
        return OrdersListDataDESC;
    }
    public List<Orders> OrdersListOrderByDoneDESC() {
        List<Orders> OrdersListDoneDESC = new ArrayList<>();
        DBManager dbManager = DBManager.getInstance();
        try (Connection connection = dbManager.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(SELECT_ALL_ORDERS_ORDER_BY_DONE_DESC)) {
            while (resultSet.next()) {
                OrdersListDoneDESC.add(mapOrders(resultSet));
            }
        } catch (SQLException e) {
            Logger.getLogger("logger5").log(Level.SEVERE, "Something went wrong in AllOrders5");
        }
        return OrdersListDoneDESC;
    }
    public List<Orders> OrdersListOrderByDevDESC() {
        List<Orders> OrdersListDevDESC = new ArrayList<>();
        DBManager dbManager = DBManager.getInstance();
        try (Connection connection = dbManager.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(SELECT_ALL_ORDERS_ORDER_BY_DEV_DESC)) {
            while (resultSet.next()) {
                OrdersListDevDESC.add(mapOrders(resultSet));
            }
        } catch (SQLException e) {
            Logger.getLogger("logger6").log(Level.SEVERE, "Something went wrong in AllOrders6");
        }
        return OrdersListDevDESC;
    }
    public List<Orders> OrdersListByPagination(int begin, int records) {
        List<Orders> OrdersListPagination = new ArrayList<>();
        DBManager dbManager = DBManager.getInstance();
        try (Connection connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDERS_FOR_PAGINATION, Statement.RETURN_GENERATED_KEYS)) {
                int k = 1;
                preparedStatement.setInt(k++, begin);
                preparedStatement.setInt(k++, records);
                ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                OrdersListPagination.add(mapOrders(rs));
            }
        } catch (SQLException e) {
            Logger.getLogger("logger7").log(Level.SEVERE, "Something went wrong in AllOrders7");
        }
        return OrdersListPagination;
    }
    public Orders mapOrders (ResultSet rs) throws SQLException {
        Orders orders = new Orders();
        orders.setId(rs.getInt(USER_ID_STRING));
        orders.setCustomerLogin(rs.getString(ORDER_CUSTOMER_STRING));
        orders.setMasterLogin(rs.getString(ORDER_MASTER_STRING));
        orders.setCreatedAt(rs.getString(ORDER_DATA_STRING));
        orders.setInDevelopment(rs.getBoolean(ORDER_STATUS_STRING));
        orders.setDone(rs.getBoolean(ORDER_DONE_STRING));
        orders.setWaitingForPayment(rs.getBoolean(ORDER_PAYMENT_STRING));
        orders.setPaid(rs.getBoolean(ORDER_PAID_STRING));
        orders.setCanceled(rs.getBoolean(ORDER_CANCELED_STRING));
        orders.setOrdersPrice(rs.getInt(ORDER_PRICE_STRING));
        orders.setCheckEngine(rs.getBoolean(ORDER_ENGINE_STRING));
        orders.setCheckElectricity(rs.getBoolean(ORDER_ELECTRICITY_STRING));
        orders.setCheckWheels(rs.getBoolean(ORDER_WHEELS_STRING));
        orders.setCarType(rs.getString(ORDER_TYPE_STRING));
        orders.setMasterReference(rs.getString(ORDER_REFERENCE_STRING));
        return orders;
    }
}
