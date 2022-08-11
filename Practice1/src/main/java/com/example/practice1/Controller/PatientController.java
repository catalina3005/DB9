package com.example.practice1.Controller;
import com.example.practice1.dto.PatientDTO;
import com.example.practice1.models.Doctor;
import com.example.practice1.models.Patient;
import com.example.practice1.service.patientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("patients")
public class PatientController {

    private final patientService patientService;

    @GetMapping("all")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("dto/all")
    public List<PatientDTO> getAllPatientsDTO(){
        return patientService.getAllPatientsDTO();
    }

    @GetMapping("id/{id}")
    public Patient getPatientById(@PathVariable Integer id){
        return patientService.getPatientById(id);
    }

    @GetMapping("dto/id/{id}")
    public PatientDTO getPatientDTOById(@PathVariable Integer id){
        return patientService.getPatientDTOById(id);
    }

    @GetMapping("doctor")
    public List<Patient> getAllPatientsByDoctor(@RequestBody Doctor doctor){
        return patientService.getAllByDoctor(doctor);
    }

    @GetMapping("dto/doctor")
    public List<PatientDTO> getAllDTOByDoctor(@RequestBody Doctor doctor){
        return patientService.getAllDTOByDoctor(doctor);
    }

    @GetMapping("cnp/{cnp}")
    public Patient getPatientByCnp(@PathVariable String cnp){
        return patientService.getByCnp(cnp);
    }

    @GetMapping("/dto/cnp/{cnp}")
    public PatientDTO getPatientDTObyCnp(@PathVariable String cnp){
        return patientService.getByCnpDTO(cnp);
    }

    @PostMapping("save")
    public void savePatient(@RequestBody Patient patient){
        patientService.savePatient(patient);
    }

    @DeleteMapping("delete/{id}")
    public void deletePatient(@PathVariable Integer id){
        patientService.deletePatient(id);
    }


}