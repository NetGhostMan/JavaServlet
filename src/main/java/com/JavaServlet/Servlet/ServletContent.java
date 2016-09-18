package com.JavaServlet.Servlet;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContent
 */
@WebServlet("/ServletContent")
public class ServletContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletContent() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		//读配置文件
		ServletConfig config = this.getServletConfig();
		String v1 = config.getInitParameter("data1");
		System.out.println("v1:" + v1);
		String v2 = config.getInitParameter("data2");
		System.out.println("v2:" + v2);
		
		//共享配置文件
		ServletContext ctx = this.getServletContext();
		String g1 = ctx.getInitParameter("globalData1");
		String g2 = ctx.getInitParameter("globalData2");
		System.out.println(g1+ "::::::::::" + g2);
		
		
		String attr = (String) ctx.getAttribute("attrbute1");
		System.out.println(attr);
		
		try {
			URL url = ctx.getResource("WEB-INF/classes/mysql.properties");
			InputStream in = url.openStream();
			String  pro = this.getPropery("password", in);
			System.out.println("viesdfsdfsdf" + pro);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("#############################################");
		InputStream in2 = ctx.getResourceAsStream("WEB-INF/classes/mysql.properties");
		String p2 = this.getPropery("url", in2);
		System.out.println(p2);
		System.out.println("#############################################");
		String path = ctx.getRealPath("WEB-INF/classes/mysql.properties");
		System.out.println(path);
		File f = new File(path);
		try {
			InputStream in3 = new FileInputStream(f);
			String p3 = this.getPropery("name", in3);
			System.out.println(p3);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public String getPropery(String key, InputStream in) {
		Properties props = new Properties();
		try {
			props.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String value = props.getProperty(key);
		return value;
	}
}
