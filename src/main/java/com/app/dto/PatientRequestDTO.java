package com.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientRequestDTO {
    private String name;
    private String email;
    private String phone;
}