package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.exception.EmployeeNotFoundException;
import com.nt.model.Employee;
import com.nt.repository.IEmployeeRepo;

@Component("empService")
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepo repo;

	@Override
	public String addEmployee(Employee emp) {
		repo.save(emp);
		return "Employee record saved...";
	}

	@Override
	public Employee getEmployee(Integer id) {
		Optional<Employee> optional = repo.findById(id);
		if (optional.isPresent())
			return optional.get();
		else
			throw new EmployeeNotFoundException("Employee with given id is not found...");
	}

	@Override
	public String updateEmployee(Employee emp) {
		Optional<Employee> optional = repo.findById(emp.getEmpNo());
		if (optional.isPresent()) {
			repo.save(emp);
			return "Employee details updated..";
		} else {
			throw new EmployeeNotFoundException("Employee is not found...");
		}
	}

	@Override
	public String updateEmpLocation(Integer id, String location) {
		Optional<Employee> optional = repo.findById(id);
		if (optional.isPresent()) {
			Employee emp = optional.get();
			emp.setEmpLocation(location);
			return "Employee Location updated";
		}
		throw new EmployeeNotFoundException("Employee is not found...");
	}

	@Override
	public String terminateEmployee(Integer id) {
		repo.deleteById(id);
		return "Employee record deleted";
	}

	@Override
	public Iterable<Employee> getAllEmployees() {
		Iterable<Employee> listEmp = repo.findAll();
		return listEmp;
	}

}
