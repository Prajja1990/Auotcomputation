package com.inops.computation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.inops.computation.entity.Muster;

public interface ComputeRepository extends JpaRepository<Muster, Long> {
	
	@Procedure
	void autometicComputeAll(String fromDate,String toDate);

}
