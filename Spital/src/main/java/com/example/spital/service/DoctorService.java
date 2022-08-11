package com.example.spital.service;

import com.example.spital.exceptions.NoDoctorException;
import com.example.spital.model.Doctor;
import com.example.spital.model.Patient;
import com.example.spital.model.Speciality;
import com.example.spital.observer.PatientObserver;
import com.example.spital.repository.DoctorRepository;
import com.example.spital.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    final DoctorRepository doctorRepository;

    final PatientRepository patientRepository;

    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    public void addPatient(Integer doctorId, Integer PatientId) throws NoDoctorException {
        Doctor d = doctorRepository.getById(doctorId);
        if(d==null)
            throw new NoDoctorException();
        else{
            Patient p = patientRepository.getById(PatientId);
            if( p != null){
                d.addPatient(p);
            }
        }
    }

    public List<Doctor> getAllBySpeciality(Speciality speciality){
        return doctorRepository.getAllBySpeciality(speciality);
    }

    public void addDoctor(Doctor doctor){
        doctorRepository.save(doctor);
    }
}