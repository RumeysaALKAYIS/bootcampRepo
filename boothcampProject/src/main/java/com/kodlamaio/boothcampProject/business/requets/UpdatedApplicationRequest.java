package com.kodlamaio.boothcampProject.business.requets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatedApplicationRequest {

	private int id;
	private String name;
	private int applicantId;
	private int boothcampId;
}
