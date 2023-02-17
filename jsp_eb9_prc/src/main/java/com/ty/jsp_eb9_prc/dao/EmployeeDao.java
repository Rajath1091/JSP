package com.ty.jsp_eb9_prc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.jsp_eb9_prc.dto.Employee;

public class EmployeeDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}

	public Employee saveEmployee(Employee employee) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();

		return employee;
	}

	public Employee getEmployeeByEmail(String email) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT e FROM Employee e WHERE e.email=?1");
		query.setParameter(1, email);
		Employee employee = (Employee) query.getSingleResult();
		return employee;
	}

	public List<Employee> getAllEmployees() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT e FROM Employee e");
		List<Employee> employees = query.getResultList();
		return employees;
	}

	public boolean deleteEmployee(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Employee employee = entityManager.find(Employee.class, id);
		if (employee != null) {
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public Employee getEmployeeById(int id) {
		return getEntityManager().find(Employee.class, id);
	}

	public Employee updateEmployee(Employee employee) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.merge(employee);
		entityTransaction.commit();

		return employee;
	}

}
