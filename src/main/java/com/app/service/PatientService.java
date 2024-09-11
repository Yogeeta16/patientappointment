package com.app.service;

import java.util.List;

import com.app.dto.PatientRequestDTO;
import com.app.dto.PatientResponseDTO;

public interface PatientService {
	 PatientResponseDTO addPatient(PatientRequestDTO patientRequestDTO);
	    List<PatientResponseDTO> listAllPatients();
	    PatientResponseDTO getPatientById(Long id);
	    PatientResponseDTO updatePatient(Long id, PatientRequestDTO patientRequestDTO);

}