package com.inops.computation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

public interface ComputeRepository extends JpaRepository<Muster, Long> {
	
	@Procedure
	void autometicComputeAll(String fromDate,String toDate);

}
