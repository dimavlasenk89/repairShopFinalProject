package controller;

import model.DBManager;
import model.entity.Managers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static controller.Constants.*;

/**
 * Servlet for entry to manager's cabinet,
 * which check's manager's login and password
 */
@WebServlet(
        name = "/allManagersServlet",
        urlPatterns = "/allManagersServlet"
)

public class allManagersServlet extends HttpServlet {
    String adminLogin;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("mLogin");
        String managerLoginString = req.getParameter(USER_LOGIN_STRING);
        String managerPasswordString = req.getParameter(USER_PASSWORD_STRING);

        String managerLogin = (String) session.getAttribute("mLogin");
        if (managerLogin == null) {
            managerLogin = managerLoginString;
        }
        session.setAttribute("mLogin", managerLogin);
        Managers man = selectManagerByLogin(managerLogin);
        if (man != null) {
            adminLogin = man.getLogin();
        }         else {
            req.setAttribute("errorAccessMessage", "невірний логін");
            RequestDispatcher view2 = req.getRequestDispatcher("signInPageManager.jsp");
            view2.forward(req, resp);
        }
        String adminPassword = man.getPassword();
        if (adminLogin.equals(managerLoginString)) {
    if (adminLogin.equals(managerLoginString) && (adminPassword.equals(managerPasswordString))) {
        req.setAttribute("congratulations", managerLoginString);
        RequestDispatcher view = req.getRequestDispatcher("managerCabinet.jsp");
        view.forward(req, resp);
    }
    else {
        req.setAttribute("errorAccessMessage", "невірний пароль");
        RequestDispatcher view2 = req.getRequestDispatcher("signInPageManager.jsp");
        view2.forward(req, resp);
         }
       }
    }
    public Managers selectManagerByLogin(String login) {
        Managers manager  = null;
        // Step 1: Establishing a Connection
        DBManager dbManager = DBManager.getInstance();
        try (Connection conn = dbManager.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = conn.prepareStatement(SELECT_MANAGER_BY_LOGIN, Statement.RETURN_GENERATED_KEYS)) {
            int k = 1;
            preparedStatement.setString(k++, login);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String managerLogin = rs.getString("login");
                String password = rs.getString("password");
                manager = new Managers(id, managerLogin, password);
            }
        } catch (SQLException e) {
            Logger.getLogger("logs").log(Level.SEVERE, "Something went wrong in allManagerServlet");
        }
        return manager;
    }
}
