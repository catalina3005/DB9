package com.example.spital.model;

import com.example.spital.observer.PatientObserver;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends Observable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotNull
    String cnp;

    @OneToMany
    List<Visit> visits = new ArrayList<>();

    @NotNull
    @ManyToOne
    Doctor doctor;

    @Transient
    PatientObserver patientObserver;

    public void setDoctor(Doctor doctor){
        this.doctor = doctor;
        patientObserver.update(this, patientObserver);
    }
}