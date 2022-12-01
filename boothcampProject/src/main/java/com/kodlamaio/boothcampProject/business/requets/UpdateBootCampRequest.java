package com.kodlamaio.boothcampProject.business.requets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBootCampRequest {
	private int id;
	private String name;
	private String dateStart;
	private String dateEnd;
	private int instructorId;
	private int State;
}
