package com.kodlamaio.boothcampProject.business.requets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatedApplicationRequest {
	private String name;
	private int applicantId;
	private int boothcampId;
}
