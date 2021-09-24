package controller;

import model.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import static controller.Constants.USER_LOGIN_STRING;
import static controller.Constants.USER_PASSWORD_STRING;


/**
 * Servlet for entry to customer's cabinet,
 * which check's customer's login and password
 */
@WebServlet(
        name = "/allCustomersServlet",
        urlPatterns = "/allCustomersServlet"
)

public class allCustomersServlet extends HttpServlet {
    public String loginValue;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userloginString = req.getParameter(USER_LOGIN_STRING);
        HttpSession session = req.getSession();
        session.removeAttribute("cLogin");
        String customerLogin = (String) session.getAttribute("cLogin");
        if (customerLogin == null) {
            customerLogin = userloginString;
        }
        session.setAttribute("cLogin", customerLogin);

        Connection con;
        DBManager dbManager = DBManager.getInstance();
        try {
            con = dbManager.getConnection();
            String[] logins = dbManager.CustomersLoginArray();
            String[] passwords = dbManager.CustomersPasswordArray();
            con.commit();
            HashMap<Integer, String> loginInfo = new HashMap<>();
            HashMap<Integer, String> passwordInfo = new HashMap<>();
            ArrayList<String> log = new ArrayList<>(Arrays.asList(logins));
            ArrayList<String> pas = new ArrayList<>(Arrays.asList(passwords));
            Iterator<String> iterator = log.iterator();
            Integer key = 0;
            while (iterator.hasNext()) {
                loginInfo.put(key, iterator.next());
                key++;
            }
            Iterator<String> passIter = pas.iterator();
            Integer keyPass = 0;
            while (passIter.hasNext()) {
                passwordInfo.put(keyPass, passIter.next());
                keyPass++;
            }

            loginValue = req.getParameter(USER_LOGIN_STRING);
            String passwordValue = req.getParameter(USER_PASSWORD_STRING);
            int k = 0;
            if (loginInfo.containsValue(loginValue)) {
                for (String string: loginInfo.values()) {
                    if (loginValue.equals(string)) {
                        break;
                    }
                    k++;
                }
            }

            String loginFromMap = loginInfo.get(k);
            String passwordFromMap = passwordInfo.get(k);

            if (loginFromMap.equals(loginValue) && (passwordFromMap.equals(passwordValue))) {
                 req.setAttribute("congratulations", loginValue);
                 RequestDispatcher view = req.getRequestDispatcher("userCabinet.jsp");
                 view.forward(req, resp);

             }
             else {
                 req.setAttribute("errorAccessMessage", "невірний логін або пароль");
                 RequestDispatcher view2 = req.getRequestDispatcher("signInPage.jsp");
                 view2.forward(req, resp);
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

