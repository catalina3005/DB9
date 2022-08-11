package com.example.practice1.service;
import com.example.practice1.dto.DoctorDTO;
import com.example.practice1.exceptions.doctorException;
import com.example.practice1.mapper.DoctorMapper;
import com.example.practice1.models.Doctor;
import com.example.practice1.models.Patient;
import com.example.practice1.models.Specialty;
import com.example.practice1.repository.doctorRepository;
import com.example.practice1.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class doctorService {

    final doctorRepository doctorRepository;
    final PatientRepository patientRepository;
    final DoctorMapper doctorMapper;

    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }
    public List<DoctorDTO> getAllDoctorsDTO(){
        return doctorRepository.findAll().stream()
                .map(doctorMapper::toDoctorDTO)
                .collect(Collectors.toList());
    }

    public void save(Doctor doctor){
        doctorRepository.save(doctor);
    }
    public void addPatient(Integer doctorId, Integer patientId) throws doctorException{
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        Optional<Patient> patient = patientRepository.findById(patientId);
        if(!doctor.isPresent()){
            throw new doctorException();
        }
        else {
            if (patient.isPresent()) {
                doctor.get().addPatient(patient.get());
                doctorRepository.save(doctor.get());
                patient.get().setDoctor(doctor.get());
                patient.get().setDoctorName();
                patientRepository.save(patient.get());
                doctorRepository.findById(doctorId).get().addPatient(patient.get());
                patientRepository.findById(patientId).get().setDoctor(doctor.get());
                System.out.println("All good. Added patient: " + patient + "\nTo doctor: " + doctor);
            }
        }

    }

    public List<Doctor> getAllBySpecialty(Specialty specialty){
        return doctorRepository.getAllBySpecialty(specialty);
    }

    public List<DoctorDTO> getAllBySpecialtyDTO(Specialty specialty){
        return doctorRepository.getAllBySpecialty(specialty).stream()
                .map(doctorMapper::toDoctorDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(Integer id){
        doctorRepository.deleteById(id);
    }


}