package com.kodlamaio.boothcampProject.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class GetAllEmployoeeResponse {
	private String position;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
}
