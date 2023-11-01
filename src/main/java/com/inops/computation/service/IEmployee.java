package com.inops.computation.service;

import java.util.List;
import java.util.Optional;

import com.inops.computation.entity.Employee;


public interface IEmployee {

	Optional<Employee> findById(long id);

	Optional<List<Employee>> findAll();
	
}
