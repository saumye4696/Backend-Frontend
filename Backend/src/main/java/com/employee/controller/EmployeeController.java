package com.employee.controller;

import java.util.Arrays;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.employee.entity.EmployeeEntity;
import com.employee.model.EmployeeModel;
import com.employee.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
@CrossOrigin(origins = "*")
@RestController 
@Api(value = ".EmployeeController , Rest APIs that deal with Customer DTO" )
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	

	
	
	@Autowired
	private EmployeeService emp;
	
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Add Employees to EmpData ", response =  EmployeeModel.class , tags = "addEmployees")
	@ApiResponses(value = {@ApiResponse(code = 200 , message = "Added the Employee Successfully"),
			@ApiResponse(code = 404 , message = "Employee could not be added")
	})
	public String addEmployee(@RequestBody EmployeeModel employeeE)
	{
		emp.addEmployees(employeeE); 
		return "Employee with name " + employeeE.getFirstName()+ employeeE.getLastName() + "added successfully";
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Show All Employees" , response = EmployeeModel.class , tags = "showEmployees")
	@ApiResponses(value = {@ApiResponse(code = 200 , message = "All the Employees are viewed"),
			@ApiResponse(code = 404 , message = "Employee data could not retrived")
	})
	public Iterable<EmployeeEntity> showEmployee(){
		return emp.showEmployees();
	}
	
	@RequestMapping(value="/{id}" ,method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete Employee record", response = EmployeeModel.class , tags = "deleteEmployeesByID" )
	@ApiResponses(value = {@ApiResponse(code = 200 , message = "Employee deleted successfull"),
			@ApiResponse(code = 404 , message = "Employee data could not retrived")
	})
	public String removeEmployee(@PathVariable int id)
	{
		emp.removeEmployee(id);
		return "Employee with id"+ id + "removed successfully";
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	@ApiOperation(value = "Show Employee by ID", response = EmployeeModel.class , tags = "showEmployeebyID" )
	@ApiResponses(value = {@ApiResponse(code = 200 , message = "Employee by Id are viewed"),
			@ApiResponse(code = 404 , message = "Employee data could not retrived")
	})
	public ResponseEntity<EmployeeEntity> findbyId(@PathVariable int id)
	{
		return ResponseEntity.ok().body(emp.findbyId(id));
		
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.PUT)
	@ApiOperation(value = "Update Employee By city", response = EmployeeModel.class , tags = "updateEmployeebyCity" )
	@ApiResponses(value = {@ApiResponse(code = 200 , message = "Employee Updated by City"),
			@ApiResponse(code = 404 , message = "Employee data could not retrived")
	})
	public String updateEmployee(@RequestBody EmployeeModel employeeE , @PathVariable int id)
	{
		String city = employeeE.getCity();
		String firstName = employeeE.getFirstName();
		String middleName = employeeE.getMiddleName();
		String lastName = employeeE.getLastName();
		String email = employeeE.getEmail();
		String dob = employeeE.getDob();
		String contactNumber = employeeE.getContactNumber();
		emp.cityUpdate(firstName ,middleName , lastName ,email , dob, city,contactNumber , id);
		return "Employee with id " + employeeE.getId() + "has been updated with city " + employeeE.getCity();
	}
	
    @GetMapping("/training")
    public List<Object> getTraining(){
    	String url="http://localhost:1019/training";
    	Object[] objects= restTemplate.getForObject(url, Object[].class);
    	
    	return Arrays.asList(objects);
    }


}
