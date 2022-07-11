package com.nt.model;

import lombok.Data;

@Data
public class Actor {

	private Integer actorId;
	private String actorName;
	private String category="Hero";
	private Long mobileNo=999999999l;

}
