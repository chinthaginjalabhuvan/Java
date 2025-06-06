package com.example;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ServletDemo extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		ServletConfig sconfig=getServletConfig();
		ServletContext scontext = getServletContext();
		String uname=sconfig.getInitParameter("username");
		String pass=sconfig.getInitParameter("password");
		PrintWriter pw=res.getWriter();
		pw.println("<html><body bgcolor='pink'>");
		pw.println("<p>Username is "+uname+" and password is "+pass+"</p>");
		pw.println("Data is "+scontext.getInitParameter("data"));
		pw.println("</body></html>");
	
	}

}