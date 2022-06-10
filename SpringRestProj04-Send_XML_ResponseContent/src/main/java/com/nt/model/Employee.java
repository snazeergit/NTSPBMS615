package com.nt.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
	private String name;
	private String[] hobbies;
	private List<String> holidaySpots;
	private Set<String> languages;
	private Map<String, Float> skillset;
	private boolean vaccinated;
	// HAS-A property
	private Company company;
}
