package com.ty.jsp_student_eb9_prc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.jsp_student_eb9_prc.dao.StudentDao;
import com.ty.jsp_student_eb9_prc.dto.Student;

@WebServlet("/login")
public class StudentLoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		StudentDao dao = new StudentDao();
		Student student = dao.getStudentByEmail(email);
		if (student.getPassword().equals(password)) {
			List<Student> students = dao.getAllStudents();
			req.setAttribute("students", students);
			RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
			dispatcher.forward(req, resp);
		} else {
			req.setAttribute("message", "Invalid Password");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}
	}

}
