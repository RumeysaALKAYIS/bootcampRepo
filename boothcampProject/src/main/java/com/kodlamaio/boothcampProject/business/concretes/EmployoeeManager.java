package com.kodlamaio.boothcampProject.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.boothcampProject.business.abstracts.EmployoeeService;
import com.kodlamaio.boothcampProject.business.constants.Messages;
import com.kodlamaio.boothcampProject.business.requets.CreatedEmployoeeRequest;
import com.kodlamaio.boothcampProject.business.requets.UpdateEmployoeeRequest;
import com.kodlamaio.boothcampProject.business.responses.CreateEmployoeeResponse;
import com.kodlamaio.boothcampProject.business.responses.GetAllEmployoeeResponse;
import com.kodlamaio.boothcampProject.business.responses.UpdateEmployoeeResponse;
import com.kodlamaio.boothcampProject.core.utilities.exeptions.BusinessExeption;
import com.kodlamaio.boothcampProject.core.utilities.mapping.ModelService;
import com.kodlamaio.boothcampProject.core.utilities.results.DataResult;
import com.kodlamaio.boothcampProject.core.utilities.results.Result;
import com.kodlamaio.boothcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.boothcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.boothcampProject.dataAccess.abstracts.EmployoeeRepository;
import com.kodlamaio.boothcampProject.entities.users.Employee;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployoeeManager implements EmployoeeService {

	private EmployoeeRepository employoeeRepository;
	private ModelService modelService;

	@Override
	public DataResult<CreateEmployoeeResponse> add(CreatedEmployoeeRequest createdEmployoeeRequest) {
		checkIfExistingByNatinalidenty(createdEmployoeeRequest.getNatinalidenty());
		Employee employee = this.modelService.forRequest().map(createdEmployoeeRequest, Employee.class);
		this.employoeeRepository.save(employee);
		CreateEmployoeeResponse createEmployoeeResponse = this.modelService.forResponse().map(employee,
				CreateEmployoeeResponse.class);

		return new SuccessDataResult<>(createEmployoeeResponse, Messages.EmployoeCreated);
	}

	@Override
	public DataResult<UpdateEmployoeeResponse> update(UpdateEmployoeeRequest updateemployoeeRequest) {
		getByNatinalIdenty(updateemployoeeRequest.getNatinalidenty());
		LocalDate dateOfBirth= stringToLocalDate(updateemployoeeRequest.getDateOfBirth());
		Employee employee = this.modelService.forRequest().map(updateemployoeeRequest, Employee.class);
		employee.setDateOfBirth(dateOfBirth);
		this.employoeeRepository.save(employee);
		UpdateEmployoeeResponse employoeeResponse = this.modelService.forResponse().map(employee,
				UpdateEmployoeeResponse.class);
		return new SuccessDataResult<>(employoeeResponse, Messages.EmployoeUpdated);
	}

	@Override
	public Result delete(int id) {
		checkIfExistingById(id);
		this.employoeeRepository.deleteById(id);

		return new SuccessResult(Messages.EmployoeDeleted);
	}

	@Override
	public DataResult<List<GetAllEmployoeeResponse>> getAll() {
		List<Employee> employees = this.employoeeRepository.findAll();
		List<GetAllEmployoeeResponse> employoeeResponses = employees.stream()
				.map(e -> this.modelService.forResponse().map(e, GetAllEmployoeeResponse.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<>(employoeeResponses);
	}

	@Override
	public DataResult<GetAllEmployoeeResponse> getById(int id) {
		Employee employee = this.employoeeRepository.findById(id).get();
		GetAllEmployoeeResponse employoeeResponse = this.modelService.forResponse().map(employee,
				GetAllEmployoeeResponse.class);
		return new SuccessDataResult<>(employoeeResponse);
	}

	private void checkIfExistingByNatinalidenty(String natinalidenty) {

		if (this.employoeeRepository.existsByNatinalIdenty(natinalidenty)) {
			throw new BusinessExeption(Messages.CheckIfExistingByNatinalidenty);
		}
	}
	
	private Employee getByNatinalIdenty(String natinalIdenty) {
		Employee employee =this.employoeeRepository.findByNatinalIdenty(natinalIdenty);
		if (employee == null) {
			new BusinessExeption(Messages.GetByNatinalIdenty);
		}
		return employee;
		
	}

 	private void checkIfExistingById(int id) {
		if (!this.employoeeRepository.existsById(id)) {
			throw new BusinessExeption(Messages.CheckIfExistingById);

		}

	}

	private LocalDate stringToLocalDate(String change) {
		return LocalDate.parse(change);

	}
}
