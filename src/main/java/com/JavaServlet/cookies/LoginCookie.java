package com.JavaServlet.cookies;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		HttpSession httpSession = request.getSession();

		String name = (String) httpSession.getAttribute("UserName");

		if (name != null) {
			System.out.println("name:" + name);
		}
		httpSession.setAttribute("UserName", username);

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
		// asdasdasdasda
	}

	public void login(HttpServletRequest request, HttpServletResponse response) {
		// 填写相应的代码
		// 从请求中获取登录用户的用户名和密码；两个字段都是字符串类型，名称分别为user和password；
		String user = request.getParameter("user");
		String password = request.getParameter("password");

		//获取cookie对象
		Cookie[] cookies = request.getCookies();
		//获取session
		HttpSession httpSession = request.getSession();

		// 后面登录的时候：
		// 因为除了第一次登录后面登录时都会带上cookie，所以只要判断cookie是否为空就知道是不是第一次登录。
		if (cookies != null) {
			httpSession.invalidate();
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("user")) {
					if(!cookie.getValue().equals(user)){
						System.out.println(user);
					}
					
				}
			}
		}else{
			// cookie 保存用户名
			Cookie userNameCookie = new Cookie("user", user);
			// session 保存密码
			httpSession.setAttribute("password", password);
			// 设置cookie的有效期为30分钟
			userNameCookie.setMaxAge(30 * 60);
		}
	
	}

}
