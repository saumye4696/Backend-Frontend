package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.employee.entity.EmployeeEntity;
import com.employee.model.EmployeeModel;



public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
	   @Transactional
	   @Modifying
	   @Query(value = "update  Employee set first_Name=?,middle_Name=?, last_Name=?,email =? , dob=? , city=? , contact_Number = ?  " + " where id = ?", nativeQuery = true)
	   void cityUpdate(String firstName , String dob , String email ,String middleName, String lastName, String contactNumber ,String city,int id);

	   
public static String createEmployee(EmployeeModel empt) {
	List<EmployeeModel> employee=null;
	employee.add(empt);
	return "emplyee with" + empt.getId() + "created successfully";
	
}

}
