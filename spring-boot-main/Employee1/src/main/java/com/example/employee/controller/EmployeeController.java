package com.example.employee.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.employeeentity.EmployeeEntity;
import com.example.employee.employeeservice.EmployeeServiceimpl;

@RestController

@RequestMapping("/lms")
public class EmployeeController {
	@Autowired
	EmployeeServiceimpl employeeService;

	@PostMapping("/employee")
	public EmployeeEntity employeedata(@RequestBody EmployeeEntity employee) {
		return employeeService.addemployee(employee);

	}

	@GetMapping("/employee/{id}")

	public EmployeeEntity getemployeedata(@PathVariable(value = "id") String id) {
		return employeeService.getemployeeById(id);

	}
	@CrossOrigin
	@GetMapping("/checkAuth")
	public String getemployeedata(@RequestParam String id,@RequestParam String password) {
		return employeeService.checkPassword(id,password);

	}


	@PutMapping("/employee/{id}")
	public EmployeeEntity updatedemployeedata (@RequestBody EmployeeEntity updateemployee ){
		return employeeService.updatedemployeeById(updateemployee) ;

	}
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> deleteemployeedata(@PathVariable(value = "id") String id){
		employeeService.deleteemployeeById(id) ;
		return new ResponseEntity<>("Employee data Deleted Successfully", HttpStatus.OK);

	}

}
