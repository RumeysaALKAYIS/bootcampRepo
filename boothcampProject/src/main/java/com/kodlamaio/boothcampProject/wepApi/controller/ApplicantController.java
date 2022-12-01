package com.kodlamaio.boothcampProject.wepApi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.boothcampProject.business.abstracts.ApplicantService;
import com.kodlamaio.boothcampProject.business.requets.CreateApplicantRequest;
import com.kodlamaio.boothcampProject.business.requets.UpdateApplicantRequest;
import com.kodlamaio.boothcampProject.business.responses.CreateApplicantResponse;
import com.kodlamaio.boothcampProject.business.responses.GetAllApplicantResponse;
import com.kodlamaio.boothcampProject.business.responses.UpdateApplicantResponse;
import com.kodlamaio.boothcampProject.core.utilities.results.DataResult;
import com.kodlamaio.boothcampProject.core.utilities.results.Result;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/applicants")
@AllArgsConstructor
public class ApplicantController {
	private ApplicantService applicantService;
	
	@GetMapping()
	public DataResult<List<GetAllApplicantResponse>> getAll(){
		return this.applicantService.getAll();
	}
	
	@PostMapping()
	public DataResult<CreateApplicantResponse> add(@RequestBody CreateApplicantRequest createApplicantRequest){
		return this.applicantService.add(createApplicantRequest);
	}
	@PutMapping()
	public DataResult<UpdateApplicantResponse> update(@RequestBody UpdateApplicantRequest createApplicantRequest){
		return this.applicantService.update(createApplicantRequest);
	}
	
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return this.applicantService.delete(id);
	}
	
	@GetMapping("/{id}")
	public DataResult<GetAllApplicantResponse> getById(@PathVariable int id) {
		return this.applicantService.getById(id);
	}



}
