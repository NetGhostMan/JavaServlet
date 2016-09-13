package com.JavaServlet.cookies;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCookie
 */
@WebServlet("/LoginCookie")
public class LoginCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginCookie() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = request.getParameter("UserName");
		String password = request.getParameter("Password");

		if (username.equals("") && password.equals("")) {
			Cookie userNameCookie = new Cookie("UserName", username);
			userNameCookie.setMaxAge(60);
			Cookie passwordCookie = new Cookie("Password", password);
			passwordCookie.setMaxAge(60);
			response.addCookie(userNameCookie);
			response.addCookie(passwordCookie);
		}

		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("UserName")) {
					username = cookie.getValue();
				}
				if (cookie.getName().equals("Password")) {
					password = cookie.getValue();
				}
			}
		}

		response.getWriter().println("UserName : " + username);
		response.getWriter().println("Password : " + password);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
