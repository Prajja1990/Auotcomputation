package com.inops.computation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface IMuster {

	Optional<List<MusterTable>> findByAttendanceDateBetween(LocalDate start, LocalDate end);

	Optional<List<MusterTable>> findAllByAttendanceDateBetweenAndEmployeeId(LocalDate start, LocalDate end, String employeeId);
	
	Optional<List<MusterTable>> findAllByAttendanceDateBetweenAndEmployeeId(LocalDate start, LocalDate end, List<String> employeeId);

}
