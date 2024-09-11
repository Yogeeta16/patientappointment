package com.app.service;


import java.util.List;

import com.app.dto.DoctorRequestDTO;
import com.app.dto.DoctorResponseDTO;


public interface DoctorService {
	 DoctorResponseDTO addDoctor(DoctorRequestDTO doctorRequestDTO);
	    List<DoctorResponseDTO> listAllDoctors();
	    DoctorResponseDTO getDoctorById(Long id);
	    DoctorResponseDTO updateDoctor(Long id, DoctorRequestDTO doctorRequestDTO);
}
