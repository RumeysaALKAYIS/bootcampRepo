package com.kodlamaio.boothcampProject.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.boothcampProject.business.requets.CreatedEmployoeeRequest;
import com.kodlamaio.boothcampProject.business.requets.UpdateEmployoeeRequest;
import com.kodlamaio.boothcampProject.business.responses.CreateEmployoeeResponse;
import com.kodlamaio.boothcampProject.business.responses.GetAllEmployoeeResponse;
import com.kodlamaio.boothcampProject.business.responses.UpdateEmployoeeResponse;
import com.kodlamaio.boothcampProject.core.utilities.results.DataResult;
import com.kodlamaio.boothcampProject.core.utilities.results.Result;

@Service
public interface EmployoeeService {

	public DataResult<List<GetAllEmployoeeResponse>> getAll();

	public DataResult<GetAllEmployoeeResponse> getById(int id);

	public DataResult<CreateEmployoeeResponse> add(CreatedEmployoeeRequest createdEmployoeeRequest);

	public DataResult<UpdateEmployoeeResponse> update(UpdateEmployoeeRequest updateemployoeeRequest);

	public Result delete(int id);

}
