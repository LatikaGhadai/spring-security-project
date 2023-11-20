package com.security.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.config.ResourceNotFoundException;
import com.security.entity.Patient;
import com.security.repo.PatientRepo;
import com.security.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private PatientRepo patientRepo;

	@Override
	public Patient save(Patient patient) {
		Patient savePat = patientRepo.save(patient);
		return savePat;
	}

	@Override
	public List<Patient> getAll() {
		List<Patient> getAll = patientRepo.findAll();
		return getAll;
	}

	@Override
	public Patient getByid(int id) {
		Patient patById = patientRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Patient not Found"));
		return patById;
	}

}
