package com.jkl.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jkl.entity.Employee;
import com.jkl.payload.EmployeeDto;
import com.jkl.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
	
	private EmployeeService employeeService;
	 public EmployeeController(EmployeeService employeeService) {
	 this.employeeService = employeeService;
	 }
	//http://localhost:8080/api/v1/employee/add
	@PostMapping("/add")
	public ResponseEntity<?> addEmployee(
			
			@Valid @RequestBody EmployeeDto dto,
			BindingResult result
			) {
		if (result.hasErrors()) {
			return new ResponseEntity<>(result.getAllErrors(),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		EmployeeDto employeeDto = employeeService.addEmployee(dto);
		return new ResponseEntity<>(employeeDto,HttpStatus.CREATED);
	}
	//http://localhost:8080/api/v1/employee?id=3
	@DeleteMapping
	public ResponseEntity<String> deleteEmployee(
			
			@RequestParam Long id
			) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>("deleted",HttpStatus.OK);
	}
	//http://localhost:8080/api/v1/employee?id=2
	@PutMapping
	public ResponseEntity<EmployeeDto> updateEmployee(
			
			@RequestParam Long id,
			@RequestBody EmployeeDto dto
			) {
		EmployeeDto employeeDto = employeeService.updateEmployee(id,dto);
		return new ResponseEntity<>(employeeDto,HttpStatus.OK);
	}
	//http://localhost:8080/api/v1/employee?pageNo=0&pageSize=3&sortBy=emailId&sortDir=asc
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getEmployees(
	@RequestParam(name = "pageSize",required = false,defaultValue = "5")int pageSize,
	@RequestParam(name = "pageNo",required = false,defaultValue = "0")int pageNo,
	@RequestParam(name = "sortBy",required = false,defaultValue = "name")String sortBy,
	@RequestParam(name = "sortDir",required = false,defaultValue = "asc")String sortDir
			) {
		List<EmployeeDto> employeesDto = employeeService.getEmployee(pageNo,pageSize,sortBy,sortDir);
		return new ResponseEntity<>(employeesDto,HttpStatus.OK);
	}
	//http://localhost:8080/api/v1/employee/employeeId/1
	@GetMapping("/employeeId/{empId}")
	public ResponseEntity<EmployeeDto> getEmployeeById(
			@PathVariable long empId
			
			) {
		EmployeeDto dto = employeeService.getEmployeeById(empId);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}
