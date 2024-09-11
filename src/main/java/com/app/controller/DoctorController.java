package com.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.dto.DoctorRequestDTO;
import com.app.dto.DoctorResponseDTO;
import com.app.service.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<DoctorResponseDTO> addDoctor(@RequestBody DoctorRequestDTO doctorRequestDTO) {
        return ResponseEntity.ok(doctorService.addDoctor(doctorRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<DoctorResponseDTO>> listAllDoctors() {
        return ResponseEntity.ok(doctorService.listAllDoctors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponseDTO> getDoctorById(@PathVariable Long id) {
        return ResponseEntity.ok(doctorService.getDoctorById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorResponseDTO> updateDoctor(@PathVariable Long id, @RequestBody DoctorRequestDTO doctorRequestDTO) {
        return ResponseEntity.ok(doctorService.updateDoctor(id, doctorRequestDTO));
    }
}
