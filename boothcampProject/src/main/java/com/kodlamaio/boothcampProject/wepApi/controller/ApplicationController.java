package com.kodlamaio.boothcampProject.wepApi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.boothcampProject.business.abstracts.ApplicationServices;
import com.kodlamaio.boothcampProject.business.requets.CreatedApplicationRequest;
import com.kodlamaio.boothcampProject.business.requets.UpdatedApplicationRequest;
import com.kodlamaio.boothcampProject.business.responses.CreatedApplicationResponse;
import com.kodlamaio.boothcampProject.business.responses.GetAllApplicationResponse;
import com.kodlamaio.boothcampProject.business.responses.UpdatedApplicationResponse;
import com.kodlamaio.boothcampProject.core.utilities.results.DataResult;
import com.kodlamaio.boothcampProject.core.utilities.results.Result;


import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/applications")
@AllArgsConstructor
public class ApplicationController {
	private ApplicationServices applicationServices;

	@GetMapping()
	public DataResult<List<GetAllApplicationResponse>> getAll() {
		return this.applicationServices.getAll();
	}
	
	@GetMapping("/{id}")
	public DataResult<GetAllApplicationResponse> getByid(@PathVariable int id){
		return this.applicationServices.getByid(id);
	}
	
	@PostMapping()
	public DataResult<CreatedApplicationResponse>  add(@RequestBody CreatedApplicationRequest createdApplicationRequest){
		return this.applicationServices.add(createdApplicationRequest);
	}
	
	@PutMapping()
	public DataResult<UpdatedApplicationResponse>  update(@RequestBody UpdatedApplicationRequest updatedApplicationRequest){
		return this.applicationServices.update(updatedApplicationRequest);
	}
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return this.applicationServices.delete(id);
		
	}
	
	
	

}
