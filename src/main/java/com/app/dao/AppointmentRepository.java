package com.app.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Appointment;
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    boolean existsByDoctorIdAndAppointmentDateAndAppointmentTime(Long doctorId, LocalDate appointmentDate, LocalTime appointmentTime);
    List<Appointment> findByDoctorIdAndAppointmentDateGreaterThanEqual(Long doctorId, LocalDate date);
   
}