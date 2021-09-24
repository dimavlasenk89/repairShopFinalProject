package controller;

import model.DBManager;
import model.entity.Master;

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
 * Servlet for entry to master's cabinet,
 * which check's master's login and password
 */
@WebServlet(
        name = "/allMastersServlet",
        urlPatterns = "/allMastersServlet"
)

public class  allMastersServlet extends HttpServlet {
    String entityMasterLogin;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("masterLogin");
        String masterLoginString = req.getParameter(USER_LOGIN_STRING);
        String masterPasswordString = req.getParameter(USER_PASSWORD_STRING);

        String masterLogin = (String) session.getAttribute("masterLogin");
        if (masterLogin == null) {
            masterLogin = masterLoginString;
        }
        session.setAttribute("masterLogin", masterLogin);
        Master mas = selectMasterByLogin(masterLogin);
        if (mas != null) {
            entityMasterLogin = mas.getLogin();
        }
        else {
            req.setAttribute("errorAccessMessage", "невірний логін");
            RequestDispatcher view2 = req.getRequestDispatcher("signInPageMaster.jsp");
            view2.forward(req, resp);
        }
        String entityMasterPassword = mas.getPassword();
        if (entityMasterLogin.equals(masterLoginString)) {
            if (entityMasterLogin.equals(masterLoginString) && (entityMasterPassword.equals(masterPasswordString))) {
                req.setAttribute("congratulations", masterLoginString);
                RequestDispatcher view = req.getRequestDispatcher("masterCabinet.jsp");
                view.forward(req, resp);
            } else {
                req.setAttribute("errorAccessMessage", "невірний пароль");
                RequestDispatcher view2 = req.getRequestDispatcher("signInPageMaster.jsp");
                view2.forward(req, resp);
            }
        }
    }
    public Master selectMasterByLogin(String login) {
        Master master  = null;
        // Step 1: Establishing a Connection
        DBManager dbManager = DBManager.getInstance();
        try (Connection conn = dbManager.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = conn.prepareStatement(SELECT_MASTER_BY_LOGIN, Statement.RETURN_GENERATED_KEYS)) {
            int k = 1;
            preparedStatement.setString(k++, login);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String masterLogin = rs.getString("login");
                String password = rs.getString("password");
                int rating = rs.getInt("rating");
                master = new Master(id, masterLogin, password, rating);
            }
        } catch (SQLException e) {
            Logger.getLogger("logs").log(Level.SEVERE, "Something went wrong in allManagerServlet");
        }
        return master;
    }
}
