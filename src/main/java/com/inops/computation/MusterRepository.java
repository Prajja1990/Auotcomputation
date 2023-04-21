package com.inops.computation;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MusterRepository extends JpaRepository<MusterTable, MusterId> {

	Optional<List<MusterTable>> findAllByMusterIdAttendanceDateBetween(Date start, Date end);

	Optional<List<MusterTable>> findAllByMusterIdAttendanceDateAfterAndMusterIdAttendanceDateBefore(Date start,
			Date end);

	Optional<List<MusterTable>> findAllByMusterIdAttendanceDateBetweenAndMusterIdEmployeeId(Date start, Date end,
			String employeeId);

	Optional<List<MusterTable>> findAllByMusterIdAttendanceDateBetweenAndMusterIdEmployeeIdIn(Date start, Date end,
			List<String> employeeId);

}
