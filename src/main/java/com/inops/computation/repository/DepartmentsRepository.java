package com.inops.computation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inops.computation.entity.Department;

public interface DepartmentsRepository extends JpaRepository<Department,String>{

}
