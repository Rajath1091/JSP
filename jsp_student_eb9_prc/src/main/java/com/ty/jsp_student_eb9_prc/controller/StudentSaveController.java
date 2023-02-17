package com.ty.jsp_student_eb9_prc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.jsp_student_eb9_prc.dao.StudentDao;
import com.ty.jsp_student_eb9_prc.dto.Student;

@WebServlet("/save")
public class StudentSaveController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String father_name = req.getParameter("father_name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		long phone = Long.parseLong(req.getParameter("phone"));

		ServletContext context = getServletContext();
		long fees = Long.parseLong(context.getInitParameter("fees"));

		Student student = new Student();
		student.setName(name);
		student.setFather_name(father_name);
		student.setEmail(email);
		student.setPassword(password);
		student.setPhone(phone);
		student.setFees(fees);

		StudentDao dao = new StudentDao();
		Student savedStudent = dao.saveStudent(student);
		if (savedStudent != null) {
			req.setAttribute("message", "Successfully Signed Up");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
		}
	}

}
