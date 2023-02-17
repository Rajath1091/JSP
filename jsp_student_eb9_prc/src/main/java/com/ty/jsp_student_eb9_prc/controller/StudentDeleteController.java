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

@WebServlet("/delete")
public class StudentDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		StudentDao dao = new StudentDao();
		boolean result = dao.deleteStudent(id);
		if (result) {
			List<Student> students = dao.getAllStudents();
			req.setAttribute("students", students);
			RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
			dispatcher.forward(req, resp);
		}
	}

}
