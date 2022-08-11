package com.example.practice1.service;
import com.example.practice1.models.Specialty;
import com.example.practice1.models.Visit;
import com.example.practice1.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitService {
    final VisitRepository visitRepository;

    public List<Visit> getAllVisits(){
        return visitRepository.findAll();
    }

    public List<Visit> getVisitsByCnp(String cnp){
        return visitRepository.findAllByPatient_Cnp(cnp);
    }

    public List<Visit> getVisitBySpecialty(Specialty specialty){
        return visitRepository.findAllByDoctor_Specialty(specialty);
    }

    public void saveVisit(Visit visit){
        visitRepository.save(visit);
    }

}