package com.kodlamaio.boothcampProject.wepApi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.boothcampProject.business.abstracts.BootCampService;
import com.kodlamaio.boothcampProject.business.requets.CreatedBootCampRequest;
import com.kodlamaio.boothcampProject.business.requets.UpdateBootCampRequest;
import com.kodlamaio.boothcampProject.business.responses.CreatedBootCampResponse;
import com.kodlamaio.boothcampProject.business.responses.GetAllBootCampResponse;
import com.kodlamaio.boothcampProject.business.responses.UpdateBootCampResponses;
import com.kodlamaio.boothcampProject.core.utilities.results.DataResult;
import com.kodlamaio.boothcampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/bootcamps")
@AllArgsConstructor
public class BootCampController {

	private BootCampService bootCampService;
	
	@GetMapping()
	DataResult<List<GetAllBootCampResponse>> getAll(){
		return this.bootCampService.getAll();
	}
	
	@PostMapping()
	public DataResult<CreatedBootCampResponse> add(@Valid @RequestBody   CreatedBootCampRequest createdBootCampRequest){
		return this.bootCampService.add(createdBootCampRequest);
	}
	
	@PutMapping()
	public DataResult<UpdateBootCampResponses> update( @RequestBody UpdateBootCampRequest updateBootCampRequest){
		return  this.bootCampService.update(updateBootCampRequest);
	}
	
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return this.bootCampService.delete(id);
	}

	
}
