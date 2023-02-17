package com.ty.jsp_eb9_prc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.jsp_eb9_prc.dao.EmployeeDao;
import com.ty.jsp_eb9_prc.dto.Employee;

@WebServlet("/save")
public class EmployeeSaveController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		long phone = Long.parseLong(req.getParameter("phone"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		Employee employee = new Employee();
		employee.setName(name);
		employee.setAddress(address);
		employee.setPhone(phone);
		employee.setEmail(email);
		employee.setPassword(password);

		EmployeeDao dao = new EmployeeDao();
		Employee savedEmployee = dao.saveEmployee(employee);
		if (savedEmployee != null) {
			req.setAttribute("message", "Successfully Signed Up");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
		}
	}

}
