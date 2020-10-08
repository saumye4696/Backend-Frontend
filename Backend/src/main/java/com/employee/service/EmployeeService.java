package com.employee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.EmployeeEntity;
import com.employee.model.EmployeeModel;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empr;
	
	
	public void addEmployees(EmployeeModel emp) {
		EmployeeEntity e = new EmployeeEntity();
		e.setId(emp.getId());
		e.setFirstName(emp.getFirstName());
		e.setMiddleName(emp.getMiddleName());
		e.setLastName(emp.getLastName());
		e.setEmail(emp.getEmail());
		e.setDob(emp.getDob());
		e.setCity(emp.getCity());
		e.setContactNumber(emp.getContactNumber());
		empr.saveAndFlush(e);
	}
	
	
	public Iterable<EmployeeEntity> showEmployees(){
		return empr.findAll();
	}
	
	
	public void removeEmployee(int id)
	{
		EmployeeEntity e = new EmployeeEntity();
		empr.deleteById(id);
	}
	
	public EmployeeEntity findbyId(int id)
	{
		Optional<EmployeeEntity> optional = this.empr.findById(id);
		return optional.get();
	
		
	}
	
	public void cityUpdate(String firstName ,String middleName , String lastName ,String email , String dob, String contactNumber ,String city , int id)
	{
		empr.cityUpdate(firstName , middleName , lastName ,email , dob, contactNumber ,city , id);
	}
	
	public String createEmployee(EmployeeModel empt)
	{
		return EmployeeRepository.createEmployee(empt);
	}
}
