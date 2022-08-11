package com.example.practice1.Controller;
import com.example.practice1.exceptions.doctorException;
import com.example.practice1.dto.DoctorDTO;
import com.example.practice1.models.Doctor;
import com.example.practice1.models.Specialty;
import com.example.practice1.service.doctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("doctors")
public class doctorController {

    private final doctorService doctorService;

    @GetMapping("all")
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("dto/all")
    public List<DoctorDTO> getAllDoctorsDTO(){
        return doctorService.getAllDoctorsDTO();
    }

    @GetMapping("specialty/{specialty}")
    public List<Doctor> getAllBySpecialty(@PathVariable Specialty specialty){
        return doctorService.getAllBySpecialty(specialty);
    }

    @GetMapping("dto/specialty/{specialty}")
    public List<DoctorDTO> getAllBySpecialtyDTO(@PathVariable Specialty specialty){
        return doctorService.getAllBySpecialtyDTO(specialty);
    }

    @PostMapping("addpatient/{doctorId}/{patientId}")
    public void addPatient(@PathVariable Integer doctorId, @PathVariable Integer patientId) throws doctorException {
        doctorService.addPatient(doctorId,patientId);
    }
    @PostMapping("save")
    public void saveDoctor(@RequestBody Doctor doctor){
        doctorService.save(doctor);
    }
    @DeleteMapping("delete/{id}")
    public void deleteDoctor(@PathVariable Integer id){
        doctorService.deleteById(id);
    }

}