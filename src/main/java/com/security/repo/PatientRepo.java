package com.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.entity.Patient;

public interface PatientRepo extends JpaRepository<Patient, Integer> {

}
