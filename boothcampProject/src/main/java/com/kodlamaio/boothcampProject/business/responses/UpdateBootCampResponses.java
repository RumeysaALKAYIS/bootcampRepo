package com.kodlamaio.boothcampProject.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBootCampResponses {
	private int id;
	private String name;
	private String dateStart;
	private String dateEnd;
	private int instructorId;
	private int State;
}
