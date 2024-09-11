package com.app.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AppointmentRepository;
import com.app.dao.DoctorRepository;
import com.app.dao.PatientRepository;
import com.app.dto.AppointmentRequestDTO;
import com.app.dto.AppointmentResponseDTO;
import com.app.entities.Appointment;
import com.app.entities.Doctor;
import com.app.entities.Patient;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ModelMapper modelMapper;
    
    public boolean appointmentExists(Long doctorId, LocalDate appointmentDate, LocalTime appointmentTime) {
        return appointmentRepository.existsByDoctorIdAndAppointmentDateAndAppointmentTime(doctorId, appointmentDate, appointmentTime);
    }
   
    
    @Override
    public AppointmentResponseDTO createAppointment(AppointmentRequestDTO requestDTO) {
        // Fetch Patient entity
        Patient patient = patientRepository.findById(requestDTO.getPatientId())
                                            .orElseThrow(() -> new EntityNotFoundException("Patient not found"));

        // Fetch Doctor entity
        Doctor doctor = doctorRepository.findById(requestDTO.getDoctorId())
                                         .orElseThrow(() -> new EntityNotFoundException("Doctor not found"));

        // Create Appointment entity
        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setAppointmentDate(requestDTO.getAppointmentDate());
        appointment.setAppointmentTime(LocalTime.parse(requestDTO.getAppointmentTime())); // Ensure proper parsing

        // Set other fields like status
        appointment.setStatus(requestDTO.getStatus());

        // Save Appointment entity
        appointment = appointmentRepository.save(appointment);

        // Map Appointment entity to AppointmentResponseDTO
        AppointmentResponseDTO responseDTO = new AppointmentResponseDTO();
        responseDTO.setId(appointment.getId());
        responseDTO.setPatientId(appointment.getPatient().getId());
        responseDTO.setDoctorId(appointment.getDoctor().getId());
        responseDTO.setAppointmentDate(appointment.getAppointmentDate());
        responseDTO.setAppointmentTime(appointment.getAppointmentTime().toString());
        responseDTO.setStatus(appointment.getStatus());

        return responseDTO;
    }
    @Override
    public List<AppointmentResponseDTO> getUpcomingAppointments(Long doctorId) {
        LocalDate currentDate = LocalDate.now();
        List<Appointment> appointments = appointmentRepository.findByDoctorIdAndAppointmentDateGreaterThanEqual(doctorId, currentDate);

        // Map Appointment entities to AppointmentResponseDTOs
        List<AppointmentResponseDTO> responseDTOs = appointments.stream()
                .map(appointment -> {
                    AppointmentResponseDTO responseDTO = new AppointmentResponseDTO();
                    responseDTO.setId(appointment.getId());
                    responseDTO.setPatientId(appointment.getPatient().getId());
                    responseDTO.setDoctorId(appointment.getDoctor().getId());
                    responseDTO.setAppointmentDate(appointment.getAppointmentDate());
                    responseDTO.setAppointmentTime(appointment.getAppointmentTime().toString());
                    responseDTO.setStatus(appointment.getStatus());
                    return responseDTO;
                })
                .collect(Collectors.toList());

        return responseDTOs;
    }

    @Override
    public void cancelAppointment(Long appointmentId) {
        if (!appointmentRepository.existsById(appointmentId)) {
            throw new RuntimeException("Appointment not found");
        }
        appointmentRepository.deleteById(appointmentId);
    }
}
