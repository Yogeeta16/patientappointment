package com.app.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AppointmentResponseDTO {
    private Long id;
    private Long patientId;
    private Long doctorId;
    private LocalDate appointmentDate;
    private String appointmentTime;
    private String status;
}

