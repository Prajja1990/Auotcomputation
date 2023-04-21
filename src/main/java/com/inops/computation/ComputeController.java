package com.inops.computation;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComputeController {

	Logger logger = LoggerFactory.getLogger(ComputeController.class);

	ComputeService computeService;

	IMuster musterService;
	IEmployee employeeService;

	public ComputeController(ComputeService computeService, IMuster musterService, IEmployee employeeService) {
		super();
		this.computeService = computeService;
		this.musterService = musterService;
		this.employeeService = employeeService;
	}

	@GetMapping(path = "/compute")
	public String getComputeForAll(@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Computation started at {}", LocalDate.now().toString());
		computeService.computeByDate(fromDate, toDate);
		logger.info("Computation ended at {}", LocalDate.now().toString());
		return "Computed successfully";
	}

	@GetMapping(path = "/getMuster")
	public List<MusterTable> getMuster(@RequestParam String fromDate, @RequestParam String toDate) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

		LocalDate fromD = LocalDate.parse(fromDate, formatter);
		LocalDate toD = LocalDate.parse(toDate, formatter);
		List<MusterTable> musters = new ArrayList<>();
		List<Employee> employees = employeeService.findAll().get();

		logger.info("getMuster started at {}", LocalDate.now().toString());
		List<MusterTable> muster = musterService.findByAttendanceDateBetween(fromD.minusDays(1), toD.plusDays(1)).get();
		try {
			if (muster != null) {

				/*
				 * employees.forEach(emp -> { if (emp.getEmployeeId() != null) { MusterTable
				 * musterData = muster.stream() .filter(must ->
				 * must.getMusterId().getEmployeeId().equals(emp.getEmployeeId()))
				 * .findAny().orElse(null); if (musterData != null) {
				 * logger.info("Muster data {}", musterData.toString());
				 * musterData.setEmpName(emp.getEmployeeName());
				 * musterData.setCdare(emp.getCadre().getCadre());
				 * musterData.setDepartment(emp.getDepartment().getDepartmentName());
				 * logger.info("Muster data {}", musterData.toString());
				 * musters.add(musterData); } } });
				 */

				muster.forEach(must -> {
					if (must.getMusterId().getEmployeeId() != null) {
						Employee employee = employees.stream()
								.filter(emp -> emp.getEmployeeId().equals(must.getMusterId().getEmployeeId())).findAny()
								.orElse(null);
						if (employee != null) {
							// logger.info("Muster data {}", must.toString());
							must.setAttendanceDate(fromD);
							must.setEmpName(employee.getEmployeeName());
							must.setCdare(employee.getCadre().getCadre());
							must.setDepartment(employee.getDepartment().getDepartmentName());
							musters.add(must);
							logger.info("Muster data {}", must.toString());
						}
					}
				});

			}
		} catch (Exception e) {
			logger.error(e.toString());
		}

		logger.info("getMuster ended at {}", LocalDate.now().toString());
		return musters;
	}
}
