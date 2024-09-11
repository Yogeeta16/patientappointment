package com.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.dto.PatientRequestDTO;
import com.app.dto.PatientResponseDTO;
import com.app.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientResponseDTO> addPatient(@RequestBody PatientRequestDTO patientRequestDTO) {
        return ResponseEntity.ok(patientService.addPatient(patientRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> listAllPatients() {
        return ResponseEntity.ok(patientService.listAllPatients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> getPatientById(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable Long id, @RequestBody PatientRequestDTO patientRequestDTO) {
        return ResponseEntity.ok(patientService.updatePatient(id, patientRequestDTO));
    }
}
