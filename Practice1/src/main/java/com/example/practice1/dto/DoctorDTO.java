package com.example.practice1.dto;
import com.example.practice1.models.Specialty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class DoctorDTO {
    private String name;
    private Specialty specialty;
    private List<String> patientsList;
}