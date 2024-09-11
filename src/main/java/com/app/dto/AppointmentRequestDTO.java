package com.app.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AppointmentRequestDTO {

    private Long patientId;
    private Long doctorId;
    private String status;
    private LocalDate appointmentDate;
    private String appointmentTime;
    
}
