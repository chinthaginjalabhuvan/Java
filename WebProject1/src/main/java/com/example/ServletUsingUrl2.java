package com.example;



import java.io.IOException;

import java.io.PrintWriter;



import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.*;

@WebServlet("/url2")

public class ServletUsingUrl2 extends HttpServlet{

@Override

public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

res.setContentType("text/html");

String url=req.getParameter("url");

res.sendRedirect(url);

}

@Override

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

// TODO Auto-generated method stub

 doGet(req, res);

}

}

