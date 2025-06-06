package com.example;



import java.io.IOException;

import java.io.PrintWriter;



import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.*;

@WebServlet("/calc")

public class ServletCalc extends HttpServlet{

@Override

public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

res.setContentType("text/html");

Calc c=new Calc();

PrintWriter pw=res.getWriter();

pw.println("<html><body bgcolor='yellow'><p>Square is "+Calc.square(5)+"</p>");

pw.println("<p>Cube is "+c.cube(10)+"</p>");

pw.println("</body></html>");

}

@Override

public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

// TODO Auto-generated method stub

doGet(req, res);

}

}

