package com.kodlamaio.boothcampProject.wepApi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.boothcampProject.business.abstracts.EmployoeeService;
import com.kodlamaio.boothcampProject.business.requets.CreatedEmployoeeRequest;
import com.kodlamaio.boothcampProject.business.requets.UpdateEmployoeeRequest;
import com.kodlamaio.boothcampProject.business.responses.CreateEmployoeeResponse;
import com.kodlamaio.boothcampProject.business.responses.GetAllEmployoeeResponse;
import com.kodlamaio.boothcampProject.business.responses.UpdateEmployoeeResponse;
import com.kodlamaio.boothcampProject.core.utilities.results.DataResult;
import com.kodlamaio.boothcampProject.core.utilities.results.Result;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employoeies")
@AllArgsConstructor
public class EmployoeeController {

	private EmployoeeService employoeeService;

	@PostMapping()
	public DataResult<CreateEmployoeeResponse> add(@RequestBody CreatedEmployoeeRequest createdEmployoeeRequest) {
		return this.employoeeService.add(createdEmployoeeRequest);
	}

	@PutMapping()
	public DataResult<UpdateEmployoeeResponse> update(@RequestBody UpdateEmployoeeRequest updateemployoeeRequest) {
		return this.employoeeService.update(updateemployoeeRequest);
	}

	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return this.employoeeService.delete(id);
	}

	@GetMapping("/{id}")
	public DataResult<GetAllEmployoeeResponse> getById(@PathVariable int id) {
		return this.employoeeService.getById(id);
	}

	@GetMapping()
	public DataResult<List<GetAllEmployoeeResponse>> getAll() {
		return this.employoeeService.getAll();
	}

}
