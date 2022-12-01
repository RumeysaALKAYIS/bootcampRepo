package com.kodlamaio.boothcampProject.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployoeeResponse  {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String position;

}
