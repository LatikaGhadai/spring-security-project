package com.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.entity.Patient;
import com.security.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@PostMapping("/save")
	public Patient savePat(@RequestBody Patient patient) {
		Patient saveP = patientService.save(patient);
		return saveP;
	}
	
	@GetMapping("/all")
	public List<Patient> getAll(){
		List<Patient> all = patientService.getAll();
		return all;
	}

}
