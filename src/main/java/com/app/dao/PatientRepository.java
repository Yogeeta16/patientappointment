package com.app.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.dto.PatientResponseDTO;
import com.app.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {


}
