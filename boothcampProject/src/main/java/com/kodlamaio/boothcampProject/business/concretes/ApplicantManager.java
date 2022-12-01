package com.kodlamaio.boothcampProject.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.boothcampProject.business.abstracts.ApplicantService;
import com.kodlamaio.boothcampProject.business.constants.Messages;
import com.kodlamaio.boothcampProject.business.requets.CreateApplicantRequest;
import com.kodlamaio.boothcampProject.business.requets.UpdateApplicantRequest;
import com.kodlamaio.boothcampProject.business.responses.CreateApplicantResponse;
import com.kodlamaio.boothcampProject.business.responses.GetAllApplicantResponse;
import com.kodlamaio.boothcampProject.business.responses.UpdateApplicantResponse;
import com.kodlamaio.boothcampProject.core.utilities.exeptions.BusinessExeption;
import com.kodlamaio.boothcampProject.core.utilities.mapping.ModelService;
import com.kodlamaio.boothcampProject.core.utilities.results.DataResult;
import com.kodlamaio.boothcampProject.core.utilities.results.Result;
import com.kodlamaio.boothcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.boothcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.boothcampProject.dataAccess.abstracts.ApplicantRepository;
import com.kodlamaio.boothcampProject.entities.users.Applicant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service

public class ApplicantManager implements ApplicantService {

	private ApplicantRepository applicantRepository;
	private ModelService modelService;

	@Override
	public DataResult<List<GetAllApplicantResponse>> getAll() {

		List<Applicant> applicants = this.applicantRepository.findAll();
		List<GetAllApplicantResponse> allApplicantResponses = applicants.stream()
				.map(a -> this.modelService.forResponse().map(applicants, GetAllApplicantResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllApplicantResponse>>(allApplicantResponses);
	}

	@Override
	public DataResult<CreateApplicantResponse> add(CreateApplicantRequest createApplicantRequest) {
		
		checkIfExistingByNatinalidenty(createApplicantRequest.getNatinalidenty());
		
		Applicant applicant = this.modelService.forRequest().map(createApplicantRequest, Applicant.class);
		applicant.setDateOfBirth(stringToLocalDate(createApplicantRequest.getDateOfBirth()));
		
		this.applicantRepository.save(applicant);
		

		CreateApplicantResponse applicantResponse = this.modelService.forResponse().map(applicant,
				CreateApplicantResponse.class);
		return new SuccessDataResult<>(applicantResponse,Messages.AplicantCreated);

	}

	@Override
	public DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest createApplicantRequest) {
	
		Applicant applicant = this.modelService.forRequest().map(createApplicantRequest, Applicant.class);
		this.applicantRepository.save(applicant);

		

		UpdateApplicantResponse applicantRespons = this.modelService.forResponse().map(applicant,
				UpdateApplicantResponse.class);
		return new SuccessDataResult<>(applicantRespons,Messages.AplicantUpdated);

	}

	@Override
	public Result delete(int id) {
		checkIfExistingById(id);
		this.applicantRepository.deleteById(id);
		return new SuccessResult(Messages.AplicantDeleted);
	}

	@Override
	public DataResult<GetAllApplicantResponse> getById(int id) {
		Applicant applicant= this.applicantRepository.findById(id).get();
		GetAllApplicantResponse allApplicantResponse= this.modelService.forResponse().map(applicant, GetAllApplicantResponse.class);
		return new SuccessDataResult<>(allApplicantResponse);
	}
	
	private void checkIfExistingByNatinalidenty(String applicant) {

//	 if( this.applicantRepository.existsByNatinalIdenty(applicant)) {
//		 throw new BusinessExeption(Messages.CheckIfExistingByNatinalidenty);
//	 }
	}
	
	private void checkIfExistingById(int id) {
		if (!this.applicantRepository.existsById(id)) {
			throw new BusinessExeption(Messages.CheckIfExistingById);
			
		}
		
	}

	private LocalDate stringToLocalDate(String change) {
		return LocalDate.parse(change);
		
	}
}
