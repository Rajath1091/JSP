package com.ty.jsp_eb9_prc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.jsp_eb9_prc.dao.EmployeeDao;
import com.ty.jsp_eb9_prc.dto.Employee;

@WebServlet("/login")
public class EmployeeLoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		EmployeeDao dao = new EmployeeDao();
		Employee employee = dao.getEmployeeByEmail(email);

		if (employee.getPassword().equals(password)) {
			HttpSession session = req.getSession();
			session.setAttribute("name", employee.getName());
			List<Employee> employees = dao.getAllEmployees();
			req.setAttribute("employees", employees);
			Cookie cookie = new Cookie("name", employee.getName());
			resp.addCookie(cookie);
			RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
			dispatcher.forward(req, resp);
		} else {
			req.setAttribute("message", "Invalid Password");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}
	}

}
