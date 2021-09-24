//package controller.filters;
//
//import controller.LoginWrapper;
//import model.DBManager;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.SQLException;
//
//import static controller.Constants.USER_LOGIN_STRING;
//
//public class DublicateLoginFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        Connection con = null;
//        DBManager dbManager = DBManager.getInstance();
//
//        try {
//            con = DBManager.getConnection();
//            String[] checkLogins = dbManager.CustomersLoginArray();
//            con.commit();
//
//            for (int i = 0; i < checkLogins.length; i++) {
//                while (i < checkLogins.length) {
//                    if (servletRequest.getParameter(USER_LOGIN_STRING).equals(checkLogins[i])) {
//                        servletRequest.setAttribute("duplicateLoginMessage", checkLogins[i]);
//                        RequestDispatcher view = servletRequest.getRequestDispatcher("duplicateLoginError.jsp");
//                        view.forward(servletRequest, servletResponse);
//                    }else {
//                        filterChain.doFilter(servletRequest, new LoginWrapper((HttpServletResponse)servletResponse));
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//}



