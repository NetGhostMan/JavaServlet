package com.JavaServlet.cookies;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class TestCookies
 */
@WebFilter("/TestCookies")
public class TestCookies implements Filter {

	/**
	 * Default constructor.
	 */
	public TestCookies() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/DoLoginServlet");
		Cookie[] cookies = httpServletRequest.getCookies();

		boolean isuser = false;
		boolean ispass = false;
		if (cookies == null) {
			isuser = false;
		} else {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					isuser = true;
				}
			}
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("password")) {
					ispass = true;
				}
			}
		}

		if (isuser && ispass) {
			requestDispatcher.forward(request, response);
		} else {
			chain.doFilter(request, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
