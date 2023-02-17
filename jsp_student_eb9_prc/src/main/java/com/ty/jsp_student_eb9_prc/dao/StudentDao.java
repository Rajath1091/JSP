package com.ty.jsp_student_eb9_prc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.jsp_student_eb9_prc.dto.Student;

public class StudentDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}

	public Student saveStudent(Student student) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();

		return student;
	}

	public Student getStudentByEmail(String email) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.email=?1");
		query.setParameter(1, email);
		Student student = (Student) query.getSingleResult();
		return student;
	}

	public List<Student> getAllStudents() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT s FROM Student s");
		List<Student> students = query.getResultList();
		return students;
	}

	public boolean deleteStudent(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student = entityManager.find(Student.class, id);
		if (student != null) {
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public Student getStudentById(int id) {
		return getEntityManager().find(Student.class, id);
	}

	public Student updateStudent(Student student) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();

		return student;
	}

}
