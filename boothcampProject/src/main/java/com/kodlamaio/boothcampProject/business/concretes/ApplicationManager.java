package com.kodlamaio.boothcampProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.boothcampProject.business.abstracts.ApplicationServices;
import com.kodlamaio.boothcampProject.business.constants.Messages;
import com.kodlamaio.boothcampProject.business.requets.CreatedApplicationRequest;
import com.kodlamaio.boothcampProject.business.requets.UpdatedApplicationRequest;
import com.kodlamaio.boothcampProject.business.responses.CreatedApplicationResponse;
import com.kodlamaio.boothcampProject.business.responses.GetAllApplicationResponse;
import com.kodlamaio.boothcampProject.business.responses.UpdatedApplicationResponse;
import com.kodlamaio.boothcampProject.core.utilities.exeptions.BusinessExeption;
import com.kodlamaio.boothcampProject.core.utilities.mapping.ModelService;
import com.kodlamaio.boothcampProject.core.utilities.results.DataResult;
import com.kodlamaio.boothcampProject.core.utilities.results.Result;
import com.kodlamaio.boothcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.boothcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.boothcampProject.dataAccess.abstracts.ApplicationRepository;
import com.kodlamaio.boothcampProject.entities.applications.Application;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ApplicationManager implements ApplicationServices {

	private ApplicationRepository applicationRepository;
	private ModelService modelService;

	@Override
	public DataResult<List<GetAllApplicationResponse>> getAll() {

		List<GetAllApplicationResponse> allApplicationResponses = this.applicationRepository.findAll().stream()
				.map(a -> this.modelService.forResponse().map(a, GetAllApplicationResponse.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<GetAllApplicationResponse>>(allApplicationResponses);
	}

	@Override
	public DataResult<GetAllApplicationResponse> getByid(int id) {
		Application application = this.applicationRepository.findById(id).get();
		GetAllApplicationResponse allApplicationResponse = this.modelService.forResponse().map(application,
				GetAllApplicationResponse.class);
		return new SuccessDataResult<GetAllApplicationResponse>(allApplicationResponse);
	}

	@Override
	public DataResult<CreatedApplicationResponse> add(CreatedApplicationRequest createdApplicationRequest) {

		Application application = this.modelService.forRequest().map(createdApplicationRequest, Application.class);

		this.applicationRepository.save(application);

		CreatedApplicationResponse applicationResponse = this.modelService.forResponse().map(application,
				CreatedApplicationResponse.class);
		return new SuccessDataResult<>(applicationResponse, Messages.ApplicationCreated);
	}

	@Override
	public DataResult<UpdatedApplicationResponse> update(UpdatedApplicationRequest updatedApplicationRequest) {
		Application application = this.modelService.forRequest().map(updatedApplicationRequest, Application.class);
		this.applicationRepository.save(application);
		UpdatedApplicationResponse applicationResponse = this.modelService.forResponse().map(application,
				UpdatedApplicationResponse.class);

		return new SuccessDataResult<>(applicationResponse, Messages.ApplicationUpdated);
	}

	@Override
	public Result delete(int id) {
		checkIfExistingById(id);
		this.applicationRepository.deleteById(id);
		return new SuccessResult();
	}

	private void checkIfExistingById(int id) {
		if (!this.applicationRepository.existsById(id)) {
			throw new BusinessExeption(Messages.CheckIfExistingById);

		}

	}

}
