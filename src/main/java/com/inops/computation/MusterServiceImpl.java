package com.inops.computation;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service("musterService")
public class MusterServiceImpl implements IMuster {

	private MusterRepository musterRepository;
	ZoneId defaultZoneId = ZoneId.systemDefault();

	public MusterServiceImpl(MusterRepository musterRepository) {
		super();
		this.musterRepository = musterRepository;
	}

	@Override
	public Optional<List<MusterTable>> findByAttendanceDateBetween(LocalDate start, LocalDate end) {

		return musterRepository.findAllByMusterIdAttendanceDateAfterAndMusterIdAttendanceDateBefore(
				Date.from(start.atStartOfDay(defaultZoneId).toInstant()),
				Date.from(end.atStartOfDay(defaultZoneId).toInstant()));

	}

	@Override
	public Optional<List<MusterTable>> findAllByAttendanceDateBetweenAndEmployeeId(LocalDate start, LocalDate end,
			String employeeId) {

		return musterRepository.findAllByMusterIdAttendanceDateBetweenAndMusterIdEmployeeId(
				Date.from(start.atStartOfDay(defaultZoneId).toInstant()),
				Date.from(end.atStartOfDay(defaultZoneId).toInstant()), employeeId);
	}

	@Override
	public Optional<List<MusterTable>> findAllByAttendanceDateBetweenAndEmployeeId(LocalDate start, LocalDate end,
			List<String> employeeId) {
		return musterRepository.findAllByMusterIdAttendanceDateBetweenAndMusterIdEmployeeIdIn(
				Date.from(start.atStartOfDay(defaultZoneId).toInstant()),
				Date.from(end.atStartOfDay(defaultZoneId).toInstant()), employeeId);
	}

}
