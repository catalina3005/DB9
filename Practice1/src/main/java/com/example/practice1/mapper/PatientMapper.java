package com.example.practice1.mapper;
import com.example.practice1.dto.PatientDTO;
import com.example.practice1.models.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    PatientDTO toPatientDTO(Patient patient);
}