package com.nt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Politician {

	private Integer pId;
	private String pName;
	private String pParty;
	private String position;
	private float age;

}
