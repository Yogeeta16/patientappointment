package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.DoctorRepository;
import com.app.dto.DoctorRequestDTO;
import com.app.dto.DoctorResponseDTO;
import com.app.entities.Doctor;
import com.app.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DoctorResponseDTO addDoctor(DoctorRequestDTO doctorRequestDTO) {
        Doctor doctor = modelMapper.map(doctorRequestDTO, Doctor.class);
        doctor = doctorRepository.save(doctor);
        return modelMapper.map(doctor, DoctorResponseDTO.class);
    }

    @Override
    public List<DoctorResponseDTO> listAllDoctors() {
        return doctorRepository.findAll().stream()
                .map(doctor -> modelMapper.map(doctor, DoctorResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public DoctorResponseDTO getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
        return modelMapper.map(doctor, DoctorResponseDTO.class);
    }

    @Override
    public DoctorResponseDTO updateDoctor(Long id, DoctorRequestDTO doctorRequestDTO) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
        modelMapper.map(doctorRequestDTO, doctor);
        doctor = doctorRepository.save(doctor);
        return modelMapper.map(doctor, DoctorResponseDTO.class);
    }
}
