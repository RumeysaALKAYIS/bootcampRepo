package com.kodlamaio.boothcampProject.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedApplicationResponse {

	private int id;
	private String name;
	private int applicantId;
	private int boothcampId;
}
