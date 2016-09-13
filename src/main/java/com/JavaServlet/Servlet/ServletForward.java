package com.JavaServlet.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletForward
 */
@WebServlet("/ServletForward")
public class ServletForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletForward() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher requestDispatcher;
		/**从request中获取转发对象*/
		//requestDispatcher = request.getRequestDispatcher("/forwardExample");
		/**从context中获取转发对象*/
//		requestDispatcher = this.getServletContext().getNamedDispatcher("ServletforwardExapmle");
		requestDispatcher = this.getServletContext().getRequestDispatcher("/forwardExample");
		
		/**
		 * 用forward方法转发*/
//		requestDispatcher.forward(request, response);
		/**
		 * 这是请求重定向*/
		response.sendRedirect("forwardExample");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
