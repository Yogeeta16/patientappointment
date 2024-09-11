package com.app.service;

import java.util.List;

import com.app.dto.AppointmentRequestDTO;
import com.app.dto.AppointmentResponseDTO;

public interface AppointmentService {
    AppointmentResponseDTO createAppointment(AppointmentRequestDTO appointmentRequestDTO);
    
//    SELECT * FROM appointments WHERE doctor_id = 1 AND appointment_datetime > NOW();
    List<AppointmentResponseDTO> getUpcomingAppointments(Long doctorId);
    void cancelAppointment(Long appointmentId);
}