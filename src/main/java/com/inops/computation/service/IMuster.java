package com.inops.computation.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.inops.computation.entity.MusterTable;


public interface IMuster {

	Optional<List<MusterTable>> findByAttendanceDateBetween(LocalDate start, LocalDate end);

	Optional<List<MusterTable>> findAllByAttendanceDateBetweenAndEmployeeId(LocalDate start, LocalDate end, String employeeId);
	
	Optional<List<MusterTable>> findAllByAttendanceDateBetweenAndEmployeeId(LocalDate start, LocalDate end, List<String> employeeId);

}
