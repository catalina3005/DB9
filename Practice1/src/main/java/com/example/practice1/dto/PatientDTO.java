package com.example.practice1.dto;
import com.example.practice1.models.Patient;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
public class PatientDTO {
    String cnp;
    String name;
    String doctorName;

     public PatientDTO(Patient patient){
        this.cnp = patient.getCnp();
        this.name = patient.getName();
        this.doctorName=patient.getDoctor().getName();
    }
}