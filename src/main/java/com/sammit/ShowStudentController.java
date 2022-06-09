package com.sammit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sammit.dao.StudentDao;
import com.sammit.model.Student;

/**
 * Servlet implementation class ShowStudentController
 */
public class ShowStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("id"));
		StudentDao dao = new StudentDao();
		Student s = dao.getStudent(id);
		
		request.setAttribute("student", s);
		
		RequestDispatcher rd = request.getRequestDispatcher("showStudent.jsp");
		rd.forward(request, response);
		
	}

	

}
