package com.chernikin.webapp.web.filter;

import com.chernikin.webapp.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebFilter("/*")
public class LoginFilter implements Filter {

    private List<String> ignoredUrls;

    @Override
    public void init(FilterConfig filterConfig) {
        ignoredUrls = Arrays.asList(
                "/WebApp/",
                "/WebApp/login",
                "/WebApp/registration-page.jsp"
        );
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("currentUser");

        String requestUri = httpServletRequest.getRequestURI();

        if (user != null && requestUri.equals("/WebApp/")) {
            httpServletRequest.getRequestDispatcher("main-products-page").forward(httpServletRequest, httpServletResponse);
            return;
        } else if (user != null) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        } else if (ignoredUrls.contains(requestUri)) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        httpServletResponse.sendRedirect("/WebApp");
    }

    @Override
    public void destroy() {

    }
}
