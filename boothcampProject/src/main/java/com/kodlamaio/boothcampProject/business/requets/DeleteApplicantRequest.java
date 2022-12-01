package com.kodlamaio.boothcampProject.business.requets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteApplicantRequest {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String about;

}
