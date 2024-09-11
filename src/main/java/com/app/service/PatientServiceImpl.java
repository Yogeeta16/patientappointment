package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.PatientRepository;
import com.app.dto.PatientRequestDTO;
import com.app.dto.PatientResponseDTO;
import com.app.entities.Patient;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PatientResponseDTO addPatient(PatientRequestDTO patientRequestDTO) {
        Patient patient = modelMapper.map(patientRequestDTO, Patient.class);
        patient = patientRepository.save(patient);
        return modelMapper.map(patient, PatientResponseDTO.class);
    }

    @Override
    public List<PatientResponseDTO> listAllPatients() {
        return patientRepository.findAll().stream()
                .map(patient -> modelMapper.map(patient, PatientResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PatientResponseDTO getPatientById(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
        return modelMapper.map(patient, PatientResponseDTO.class);
    }

    @Override
    public PatientResponseDTO updatePatient(Long id, PatientRequestDTO patientRequestDTO) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
        modelMapper.map(patientRequestDTO, patient);
        patient = patientRepository.save(patient);
        return modelMapper.map(patient, PatientResponseDTO.class);
    }
}
