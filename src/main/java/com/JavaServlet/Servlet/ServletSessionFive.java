package com.JavaServlet.Servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletSessionFive
 */
@WebServlet("/ServletSessionFive")
public class ServletSessionFive extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletSessionFive() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		ServletContext servletContext = this.getServletContext();

		String ed = "WEB-INF/classes/mysql.properties";
		URL url;
		try {
			url = servletContext.getResource(ed);
			InputStream inputStream;
			inputStream = url.openStream();
			String string = getvalue("url", inputStream);
			
			System.out.println(string);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("#######################################");
		
		InputStream inputStream2 = servletContext.getResourceAsStream(ed);
		String string1 = getvalue("url", inputStream2);
		System.out.println(string1);
		
		System.out.println("#######################################");
		
		String path = servletContext.getRealPath(ed);
		File file = new File(path);
		InputStream inputStream3;

		try {
			inputStream3 = new FileInputStream(file);
			String string2 = getvalue("url", inputStream3);
			System.out.println(string2);
			System.out.println(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

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

	private String getvalue(String key, InputStream in) {
		// TODO Auto-generated method stub
		Properties propweties = new Properties();
		try {
			propweties.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return propweties.getProperty(key);
	}
}
