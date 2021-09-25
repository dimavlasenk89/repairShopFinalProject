package controller;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.UNICODE_CHARACTER_CLASS;

public class Constants {
    public static final String USER_LOGIN_STRING = "login";
    public static final String USER_ID_STRING = "id";
    public static final String USER_BILL_STRING = "bill";
    public static final String USER_PASSWORD_STRING = "password";
    public static final String ORDER_CUSTOMER_STRING = "CustomerLogin";
    public static final String ORDER_MASTER_STRING = "masterLogin";
    public static final String ORDER_DATA_STRING = "createdAt";
    public static final String ORDER_STATUS_STRING = "is_in_development";
    public static final String ORDER_DONE_STRING = "is_done";
    public static final String ORDER_PAYMENT_STRING = "is_waiting_for_payment";
    public static final String ORDER_PAID_STRING = "is_paid";
    public static final String ORDER_CANCELED_STRING = "is_canceled";
    public static final String ORDER_PRICE_STRING = "ordersPrice";
    public static final String ORDER_ENGINE_STRING = "is_CheckEngine";
    public static final String ORDER_ELECTRICITY_STRING = "is_CheckElectricity";
    public static final String ORDER_WHEELS_STRING = "is_CheckWheels";
    public static final String ORDER_TYPE_STRING = "car_type";
    public static final String ORDER_REFERENCE_STRING = "master_reference";
    public static final String BAD_WORD = "some bad word";
    public static final String GET_ALL_CUSTOMERS = "SELECT * FROM repair_shop.customers ORDER BY id";
    public static final String SELECT_ALL_ORDERS = "SELECT * FROM repair_shop.orders ORDER BY id";
    public static final Pattern LOCAL_LOGIN_PATTERN = Pattern.compile("(?<=').{1,20}(?=')", UNICODE_CHARACTER_CLASS);
    public static final Pattern LOCAL_PASSWORD_PATTERN = Pattern.compile("(?<=\\.).{1,20}(?=\\.)", UNICODE_CHARACTER_CLASS);
    public static final Pattern LOCAL_SPLIT_PATTERN = Pattern.compile("'");
    public static final String SQL_INSERT_CUSTOMER = "INSERT INTO customers VALUES (DEFAULT, ?, ?, ?)";
    public static final String SQL_ADD_NEW_ORDER = "INSERT INTO orders VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SELECT_ALL_ORDERS_BY_MASTER_LOGIN = "select o.* from repair_shop.orders o, repair_shop.masters m " +
            "where o.masterLogin=m.login and m.login=";
    public static final String SELECT_ALL_ORDERS_BY_PAYMENT_STATUS = "select o.* from repair_shop.orders o where o.is_paid=1";
    public static final String SELECT_ALL_ORDERS_BY_CANCELED_STATUS = "select o.* from repair_shop.orders o where o.is_canceled=1";
    public static final String SELECT_ALL_ORDERS_BY_WAITING_FOR_PAYMENT_STATUS = "select o.* from repair_shop.orders o where o.is_waiting_for_payment=1";
    public static final String SELECT_ORDER_BY_ID = "SELECT is_in_development, is_done, is_paid, is_waiting_for_payment, is_canceled, " +
            "is_CheckEngine, is_CheckElectricity, is_CheckWheels, Id, ordersPrice, CustomerLogin, masterLogin, createdAt, car_type, master_reference " +
            "FROM repair_shop.orders where Id=?";
    public static final String SELECT_ORDER_PRICE_BY_ID = "SELECT ordersPrice FROM repair_shop.orders where Id=?";
    public static final String SELECT_BILL_BY_LOGIN = "SELECT bill FROM repair_shop.customers where login=?";
    public static final String SELECT_ALL_ORDERS_BY_LOGIN = "select o.* from repair_shop.orders o, repair_shop.customers c " +
            "where o.CustomerLogin=c.login and c.login=";
    public static final String SELECT_MANAGER_BY_LOGIN = "SELECT id, login, password FROM repair_shop.managers where login=?";
    public static final String SELECT_MASTER_BY_LOGIN = "SELECT id, login, password, rating FROM repair_shop.masters where login=?";
    public static final String MASTER_DONE_ORDER = "UPDATE orders SET masterLogin=?, is_in_development='0', is_done='1' WHERE id=?";
    public static final String MASTER_UPDATE_ORDER = "UPDATE orders SET masterLogin=?, is_in_development='1' WHERE id=?";
    public static final String PRICE_UPDATE_ORDER = "UPDATE orders SET ordersPrice=? WHERE id=?";
    public static final String BILL_UPDATE_CUSTOMER = "UPDATE customers SET bill=? WHERE id=?";
    public static final String BILL_UPDATE = "UPDATE customers SET bill=? WHERE login=?";
    public static final String REFERENCE_UPDATE = "UPDATE orders SET master_reference=? WHERE id=?";
    public static final String UPDATE_MASTER_BY_MANAGER = "UPDATE orders SET masterLogin=? WHERE id=?";
    public static final String UPDATE_PAYMENT_STATUS = "UPDATE orders SET is_waiting_for_payment='1' WHERE id=?";
    public static final String UPDATE_PAYMENT_STATUS_PAID = "UPDATE orders SET is_waiting_for_payment='0', is_paid='1' WHERE id=?";
    public static final String UPDATE_PAYMENT_STATUS_CANCELED = "UPDATE orders SET is_waiting_for_payment='0', is_paid='0', is_canceled='1' WHERE id=?";
    public static final String SELECT_ALL_ORDERS_ORDER_BY_PRICE_DESC = "SELECT * FROM repair_shop.orders ORDER BY ordersPrice DESC";
    public static final String SELECT_ALL_ORDERS_ORDER_BY_PRICE_ASC = "SELECT * FROM repair_shop.orders ORDER BY ordersPrice ASC";
    public static final String SELECT_ALL_ORDERS_ORDER_BY_DATA_DESC = "SELECT * FROM repair_shop.orders ORDER BY CreatedAt DESC";
    public static final String SELECT_ALL_ORDERS_ORDER_BY_DATA_ASC = "SELECT * FROM repair_shop.orders ORDER BY CreatedAt ASC";
    public static final String SELECT_ALL_ORDERS_ORDER_BY_PAYMENT_DESC = "SELECT * FROM repair_shop.orders ORDER BY is_paid DESC";
    public static final String SELECT_ALL_ORDERS_ORDER_BY_DONE_DESC = "SELECT * FROM repair_shop.orders ORDER BY is_done DESC";
    public static final String SELECT_ALL_ORDERS_ORDER_BY_DEV_DESC = "SELECT * FROM repair_shop.orders ORDER BY is_in_development DESC";
}



//    public static final String SELECT_ORDER_BY_LOGIN = "SELECT is_in_development, is_done, is_paid, is_waiting_for_payment, is_canceled, " +
//            "is_CheckEngine, is_CheckElectricity, is_CheckWheels, ordersPrice, masterLogin, createdAt, car_type " +
//            "FROM repair_shop.orders where CustomerLogin=?";
//public static final String SELECT_ORDER_BY_MASTER_LOGIN = "SELECT is_in_development, is_done, is_paid, is_waiting_for_payment, is_canceled, " +
//        "is_CheckEngine, is_CheckElectricity, is_CheckWheels, ordersPrice, CustomerLogin, createdAt, car_type, master_reference " +
//        "FROM repair_shop.orders where masterLogin=";
//public static final String ALL_USER_ORDERS = "select o.* from repair_shop.orders o, repair_shop.customers c where o.CustomerLogin=c.login and c.login=?";