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

import com.kodlamaio.boothcampProject.business.abstracts.InstructorService;
import com.kodlamaio.boothcampProject.business.requets.CreateInstructorRequest;
import com.kodlamaio.boothcampProject.business.requets.UpdateInstructorRequest;
import com.kodlamaio.boothcampProject.business.responses.CreateInstructorResponse;
import com.kodlamaio.boothcampProject.business.responses.GetAllInstructorResponse;
import com.kodlamaio.boothcampProject.business.responses.GetInstructorResponse;
import com.kodlamaio.boothcampProject.business.responses.UpdateInstructorResponse;
import com.kodlamaio.boothcampProject.core.utilities.results.DataResult;
import com.kodlamaio.boothcampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/instructors")
@AllArgsConstructor
public class InstructorsController {
	private InstructorService instructorService;

	@GetMapping("/{id}")
	public DataResult<GetInstructorResponse> getById(@PathVariable int id){
		return this.instructorService.getById(id);
	}
	@GetMapping()
	public DataResult<List<GetAllInstructorResponse>> getAll(){
		return this.instructorService.getAll();
	}
	
	@PostMapping()
	 DataResult<CreateInstructorResponse> add(@RequestBody CreateInstructorRequest createInstructorRequest){
		return this.instructorService.add(createInstructorRequest);
	}
	@PutMapping()
	public DataResult<UpdateInstructorResponse> update(@RequestBody UpdateInstructorRequest updateInstructorRequest){
		return this.instructorService.update(updateInstructorRequest);
	}
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int  id) {
		 return this.instructorService.delete( id);
	 }
}
