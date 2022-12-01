package com.kodlamaio.boothcampProject.business.requets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicantRequest {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String about;
	private String natinalidenty;
	private String dateOfBirth;
}
