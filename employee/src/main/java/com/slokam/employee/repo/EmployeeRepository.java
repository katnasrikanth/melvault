package com.slokam.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slokam.employee.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
