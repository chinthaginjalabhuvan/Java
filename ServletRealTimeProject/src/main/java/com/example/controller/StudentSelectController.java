package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;



import com.example.bean.StudentBean;
import com.example.dao.StudentDao;


@WebServlet("/selectAll")

public class StudentSelectController extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		ArrayList<StudentBean> all=StudentDao.selectAll();
		PrintWriter pw=res.getWriter();
		pw.println("<html><body bgcolor='cyan'>");
		pw.println("<table border='4'>");
		pw.println("<tr><th>Rollno</th><th>Name</th><th>Branch</th></tr>");
		
		for(StudentBean sb:all){
			pw.println("<tr><td>"+sb.getRollno()+"</td><td>"+sb.getName()+"</td><td>"+sb.getBranch()+"</td></tr>");
		}
		
		pw.println("</table></body></html>");
	
	}

}

