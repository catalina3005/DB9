package com.example.spital.mapper;

import com.example.spital.dto.PatientDTO;
import com.example.spital.model.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    PatientDTO toPatientDTO(Patient patient);
}