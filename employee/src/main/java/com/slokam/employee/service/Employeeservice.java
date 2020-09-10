package com.slokam.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.cci.RecordTypeNotSupportedException;
import org.springframework.stereotype.Service;

import com.slokam.employee.Employee;
import com.slokam.employee.repo.EmployeeRepository;

@Service
public class Employeeservice {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> 	getAllEmployees(){
		
		List<Employee> 	employeelist=employeeRepository.findAll();
		
		if(employeelist.size()>0) {
			return employeelist;
		}else {
			return new ArrayList<Employee>();
		}
	}
	
	public Employee getbyid(Long id) {
		
		return employeeRepository.findById(id).get();
		
	}
	
	public Employee save(Employee emp){
	
		return employeeRepository.save(emp);
	}
	
	public void deleteEmployeebyid(Long id) {
		Optional<Employee> employee=employeeRepository.findById(id);
		if(employee.isPresent()) {
			employeeRepository.deleteById(id);
			
		}
	}
	
}
