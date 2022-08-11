package com.example.spital.dto;
import com.example.spital.model.Doctor;
import com.example.spital.model.Speciality;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {
    String name;
    Speciality speciality;

    public DoctorDTO (Doctor doctor){
        this.name = doctor.getName();
        this.speciality = doctor.getSpeciality();
    }
}