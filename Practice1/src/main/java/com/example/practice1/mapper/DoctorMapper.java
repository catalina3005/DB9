package com.example.practice1.mapper;
import com.example.practice1.dto.DoctorDTO;
import com.example.practice1.models.Doctor;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface DoctorMapper {
    DoctorDTO toDoctorDTO(Doctor Doctor);
}