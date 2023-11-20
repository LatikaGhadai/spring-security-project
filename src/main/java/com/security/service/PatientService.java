package com.security.service;

import java.util.List;

import com.security.entity.Patient;

public interface PatientService {
	
	public Patient save(Patient patient);
	public List<Patient> getAll();
	public Patient getByid(int id);

}
