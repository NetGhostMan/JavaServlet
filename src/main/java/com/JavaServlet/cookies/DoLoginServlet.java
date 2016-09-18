package com.JavaServlet.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DoLoginServlet
 */
@WebServlet("/DoLoginServlet")
public class DoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoLoginServlet() {
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
		Cookie[] cookies = request.getCookies();
		
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
			doLogin(response, cookies);
		} else {
			doLogin(request, response);
		}
	}

	private void doLogin(HttpServletResponse response, Cookie[] cookies) {
		// TODO Auto-generated method stub

		String username = "";
		String password = "";
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("username")) {
				username = cookie.getValue();
			}
			if (cookie.getName().equals("password")) {
				password = cookie.getValue();
			}
		}
		login(username, password, response);
	}

	private void doLogin(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		login(username, password, response,request);

	}
	
	private void login(String username, String password, HttpServletResponse response, HttpServletRequest request) {
		// TODO Auto-generated method stub
		if (username.equals("123") && password.equals("123")) {
			doSuess(response);
			Cookie usernameCookie = new Cookie("username",username);
			Cookie passwordCookie = new Cookie("password",password);
			
			response.addCookie(usernameCookie);
			response.addCookie(passwordCookie);
			
		} else {
			doSorry(response);
		}
	}

	private void login(String username,String password,HttpServletResponse response){
		if (username.equals("123") && password.equals("123")) {
			doSuess(response);
			
		} else {
			doSorry(response);
		}
	}

	private void doSorry(HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			PrintWriter printWriter = response.getWriter();
			printWriter.println("No you cannet");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void doSuess(HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			PrintWriter printWriter = response.getWriter();
			printWriter.println("Yes you are yes");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
