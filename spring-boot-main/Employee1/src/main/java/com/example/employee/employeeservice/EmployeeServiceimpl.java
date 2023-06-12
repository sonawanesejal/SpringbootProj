package com.example.employee.employeeservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.example.employee.dao.EmployeeDao;
import com.example.employee.employeeentity.EmployeeEntity;

@Service

public class EmployeeServiceimpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	public EmployeeEntity addemployee(EmployeeEntity employee) {
		return employeeDao.save(employee);

	}

	public String checkPassword(String id, String password) {

		if (id.length() > 0 && id.equals("sejal")) {
			if(password.equals("abcd@123"))
			{
			return "authPass";
			}
			else
			{
				return "noAuth";
			}
		} else {
		}
		return "noUser";

	}
	@Override
	public EmployeeEntity getemployeeById(String id) {
		Optional<EmployeeEntity> employeeData = employeeDao.findById(id);

		if (employeeData.isPresent()) {
			return employeeData.get();
		} else {
		}
		return null;

	}

	@Override
	public EmployeeEntity updatedemployeeById( EmployeeEntity updateemployee ) {

		return employeeDao.save(updateemployee);
	}
	
	@Override
	public void deleteemployeeById(String id) {
		EmployeeEntity employeeentity = getemployeeById(id);
		
		employeeDao.deleteById(employeeentity.getId());
		
	}


}