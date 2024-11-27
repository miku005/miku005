package com.jkl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jkl.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
