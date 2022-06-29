package com.nt.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "EMPLOYEE_MODEL")
public class Employee {

	@Id
	@GeneratedValue
	private Integer empNo;

	@Column(length = 20)
	private String empName;

	@Column(length = 20)
	private String empLocation;

	@Column(length = 20)
	private String empSkillSet;

}
