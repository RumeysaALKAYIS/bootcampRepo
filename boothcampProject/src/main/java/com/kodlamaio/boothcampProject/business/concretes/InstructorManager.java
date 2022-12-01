package com.kodlamaio.boothcampProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.boothcampProject.business.abstracts.InstructorService;
import com.kodlamaio.boothcampProject.business.constants.Messages;
import com.kodlamaio.boothcampProject.business.requets.CreateInstructorRequest;
import com.kodlamaio.boothcampProject.business.requets.UpdateInstructorRequest;
import com.kodlamaio.boothcampProject.business.responses.CreateInstructorResponse;
import com.kodlamaio.boothcampProject.business.responses.GetAllInstructorResponse;
import com.kodlamaio.boothcampProject.business.responses.GetInstructorResponse;
import com.kodlamaio.boothcampProject.business.responses.UpdateInstructorResponse;
import com.kodlamaio.boothcampProject.core.utilities.mapping.ModelService;
import com.kodlamaio.boothcampProject.core.utilities.results.DataResult;
import com.kodlamaio.boothcampProject.core.utilities.results.Result;
import com.kodlamaio.boothcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.boothcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.boothcampProject.dataAccess.abstracts.InstracterRepository;
import com.kodlamaio.boothcampProject.entities.users.Instructor;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService {

	private InstracterRepository instracterRepository;
	private ModelService modelService;

	@Override
	public Result delete(int id) {
		this.instracterRepository.deleteById(id);

		return new SuccessResult(Messages.InstructorDeleted);
	}

	@Override
	public DataResult<CreateInstructorResponse> add(CreateInstructorRequest createInstructorRequest) {
		Instructor instructor = this.modelService.forRequest().map(createInstructorRequest, Instructor.class);
		this.instracterRepository.save(instructor);
		CreateInstructorResponse createInstructorResponse = this.modelService.forResponse().map(instructor,
				CreateInstructorResponse.class);

		return new SuccessDataResult<CreateInstructorResponse>(createInstructorResponse, Messages.InstrutorCreated);
	}

	@Override
	public DataResult<List<GetAllInstructorResponse>> getAll() {
		List<Instructor> instructors = this.instracterRepository.findAll();
		List<GetAllInstructorResponse> response = instructors.stream()
				.map(instructor -> this.modelService.forResponse().map(instructor, GetAllInstructorResponse.class))
				.collect(Collectors.toList());// Collecti bitir listeye çevir

		return new SuccessDataResult<List<GetAllInstructorResponse>>(response);
	}

	@Override
	public DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest updateInstructorRequest) {
		Instructor instructor = this.modelService.forRequest().map(updateInstructorRequest, Instructor.class);
		this.instracterRepository.save(instructor);
		UpdateInstructorResponse response = this.modelService.forResponse().map(instructor,
				UpdateInstructorResponse.class);
		return new SuccessDataResult<UpdateInstructorResponse>(response, Messages.InstructorUpdated);
	}

	@Override
	public DataResult<GetInstructorResponse> getById(int id) {
		Instructor instructor = this.instracterRepository.findById(id).get();
		GetInstructorResponse getInstructorResponse = this.modelService.forResponse().map(instructor,
				GetInstructorResponse.class);
		return new SuccessDataResult<GetInstructorResponse>(getInstructorResponse);
	}
}
