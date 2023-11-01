package com.inops.computation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inops.computation.entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee,String> {

}
