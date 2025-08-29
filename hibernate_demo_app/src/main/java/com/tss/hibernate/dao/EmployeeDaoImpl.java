package com.tss.hibernate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tss.hibernate.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EntityManager manager;

	@Override
	@Transactional
	public Employee addNewEmployee(Employee employee) {
		return manager.merge(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		TypedQuery<Employee> query = manager.createQuery("SELECT e FROM Employee e", Employee.class);
		return query.getResultList();
	}

	@Override
	public Employee getEmployeeById(int id) {
		return manager.find(Employee.class, id);
	}

	@Override
	public List<Employee> getEmployeesByName(String name) {
		TypedQuery<Employee> query = manager
				.createQuery("SELECT e FROM Employee e WHERE LOWER(e.name) LIKE LOWER(:name)", Employee.class);
		query.setParameter("name", "%" + name + "%");
		return query.getResultList();
	}

	@Override
	public List<Employee> getEmployeesBySalary(double salary) {
		TypedQuery<Employee> query = manager.createQuery("SELECT e FROM Employee e WHERE e.salary = :salary",
				Employee.class);
		query.setParameter("salary", salary);
		return query.getResultList();
	}

	@Override
	public List<Employee> getEmployeesByDept(String deptName) {
		TypedQuery<Employee> query = manager
				.createQuery("SELECT e FROM Employee e WHERE LOWER(e.deptName) LIKE LOWER(:dept)", Employee.class);
		query.setParameter("dept", "%" + deptName + "%");
		return query.getResultList();
	}
}
