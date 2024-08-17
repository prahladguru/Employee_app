package com.empapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empapp.entity.Employee;
import com.empapp.entity.repository.EmployeeRepository;

@Service
public class EmployeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void addEmployee(Employee emp) {
		  employeeRepository.save(emp);
	}

	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees = employeeRepository.findAll();
		System.out.println(employees);
		return employees;
	}
	public void deleteEmployee(long id) {
		employeeRepository.deleteById(id);
	}

	public Optional<Employee> getEmployeeById(long id) {
		return employeeRepository.findById(id);
	
	}

	public void updateEmployee(Employee emp) {
		 employeeRepository.save(emp);
		
	}
    
}
