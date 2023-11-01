package com.inops.computation.service.impl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.inops.computation.repository.ComputeRepository;

@Service
public class ComputeService {

	private final ComputeRepository computeRepository;

	public ComputeService(ComputeRepository computeRepository) {
		super();
		this.computeRepository = computeRepository;
	}

	public void compute() {
		computeRepository.autometicComputeAll(LocalDate.now().toString(), LocalDate.now().toString());
	}

	public void computeByDate(String fromDate, String toDate) {
		computeRepository.autometicComputeAll(fromDate, toDate);
	}

}
