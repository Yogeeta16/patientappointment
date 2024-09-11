package com.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.dto.AppointmentRequestDTO;
import com.app.dto.AppointmentResponseDTO;
import com.app.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppointmentResponseDTO> createAppointment(@RequestBody AppointmentRequestDTO appointmentRequestDTO) {
        return ResponseEntity.ok(appointmentService.createAppointment(appointmentRequestDTO));
    }

    @GetMapping("/{doctorId}/upcoming")
    public ResponseEntity<List<AppointmentResponseDTO>> getUpcomingAppointments(@PathVariable Long doctorId) {
        return ResponseEntity.ok(appointmentService.getUpcomingAppointments(doctorId));
    }

    @DeleteMapping("/{appointmentId}")
    public ResponseEntity<Void> cancelAppointment(@PathVariable Long appointmentId) {
        appointmentService.cancelAppointment(appointmentId);
        return ResponseEntity.ok().build();
    }
}
