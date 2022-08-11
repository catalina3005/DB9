package com.example.spital.mapper;

import com.example.spital.dto.DoctorDTO;
import com.example.spital.model.Doctor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    DoctorDTO toDoctorDTO(Doctor doctor);
}
