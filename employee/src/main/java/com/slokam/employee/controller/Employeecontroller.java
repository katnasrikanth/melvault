package com.slokam.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jca.cci.RecordTypeNotSupportedException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.employee.Employee;
import com.slokam.employee.repo.EmployeeRepository;
import com.slokam.employee.service.Employeeservice;

@RestController
@RequestMapping("/api/employee")
public class Employeecontroller {
	
	@Autowired
	Employeeservice service;
	
	//@Autowired
	//EmployeeRepository repository;
	
	@GetMapping("/All")
	public ResponseEntity<List<Employee>> getAllemployees(){
		List<Employee> employee=service.getAllEmployees();
		
		return new ResponseEntity<List<Employee>>(employee,new HttpHeaders(),HttpStatus.OK);
	}
	@GetMapping("{id}")
	public ResponseEntity<Employee> getbyid(@PathVariable("id") Long id){
		Employee employee=service.getbyid(id);
		return new ResponseEntity<Employee>(employee,new HttpHeaders(),HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> update(@RequestBody Employee emp){
		Employee employee=service.save(emp);
		return new ResponseEntity<Employee>(employee,new HttpHeaders(),HttpStatus.OK);
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<Employee> save(@RequestBody Employee emp){	
		Employee employee=service.save(emp);
		return new ResponseEntity<Employee>(employee,new HttpHeaders(),HttpStatus.OK);
}
	@DeleteMapping("{id}")
	public HttpStatus deleteEmployeebyid(@PathVariable("id")Long id) {
		service.deleteEmployeebyid(id);
		return HttpStatus.FORBIDDEN;
	}

}
