package com.JavaServlet.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("doGet method.");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw = response.getWriter();
		pw.print("hello world");
		String name1 = request.getParameter("name1");
		String pw1 = request.getParameter("pw1");
		pw.println("<HTML>");
		pw.println("<HEAD><TITLE>A Servletget</TITLE></HEAD>");
		pw.println("<BODY>");
		pw.println("调用doget方法");
		pw.println("<HR>");
		pw.println("用户名："+ name1);
		pw.println("<HR>");
		pw.println("密码："+ pw1);
		pw.println("</BODY>");
		pw.println("</HTML>");
		pw.flush();
		pw.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		String name2 = request.getParameter("name2");
		String pw2 = request.getParameter("pw2");
		pw.println("<HTML>");
		pw.println("<HEAD><TITLE>A Servletpost</TITLE></HEAD>");
		pw.println("<BODY>");
		pw.println("调用dopost方法");
		pw.println("<HR>");
		pw.println("用户名："+ name2);
		pw.println("<HR>");
		pw.println("密码："+ pw2);
		pw.println("</BODY>");
		pw.println("</HTML>");
		pw.flush();
		pw.close();
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service method.");
		super.service(arg0, arg1);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy method.");
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init method.");
		ServletContext ctx = this.getServletContext();
		/**
		 * @see 共享配置文件文件
		 * */
		String g1 = ctx.getInitParameter("globalData1");
		String g2 = ctx.getInitParameter("globalData2");
		System.out.println(g1+ "111111111111111" + g2);
		/**
		 * @see 动态共享配置文件
		 * */
		ctx.setAttribute("attrbute1","11");
	}
	

}
