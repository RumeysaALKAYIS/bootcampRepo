package com.kodlamaio.boothcampProject.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicantResponse {
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String about;
	private String dateOfBirth;
}
