package com.nt.service;

import com.nt.model.Employee;

public interface IEmployeeService {

	//POST
	public String addEmployee(Employee emp);

	//GET
	public Employee getEmployee(Integer id);

	//PUT
	public String updateEmployee(Employee emp);

	//PATCH
	public String updateEmpLocation(Integer id, String location);

	//DELETE
	public String terminateEmployee(Integer id);

	//GET
	public  Iterable<Employee> getAllEmployees();

}
