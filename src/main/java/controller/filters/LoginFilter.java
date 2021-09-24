package controller.filters;

import controller.LoginWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static controller.Constants.BAD_WORD;
import static controller.Constants.USER_LOGIN_STRING;

/**
 * filter, which forbid using particular words as user's login
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        if (servletRequest.getParameter(USER_LOGIN_STRING).equals(BAD_WORD)) {
            RequestDispatcher view = servletRequest.getRequestDispatcher("error.jsp");
            view.forward(servletRequest, servletResponse);
        }else {
            filterChain.doFilter(servletRequest, new LoginWrapper((HttpServletResponse)servletResponse));
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
