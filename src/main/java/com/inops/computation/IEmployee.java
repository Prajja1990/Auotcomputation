package com.inops.computation;

import java.util.List;
import java.util.Optional;


public interface IEmployee {

	Optional<Employee> findById(long id);

	Optional<List<Employee>> findAll();
	
}
