package com.example.spital.model;

import com.example.spital.exceptions.NoDoctorException;
import com.example.spital.repository.PatientRepository;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotNull
    String name;

    @OneToMany
    List<Patient> patientList = new ArrayList<>();

    Speciality speciality;

    public void addPatient(Patient patient){
        this.patientList.add(patient);
    }

}