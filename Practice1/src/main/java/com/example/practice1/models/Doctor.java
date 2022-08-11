package com.example.practice1.models;
import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@ToString(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotNull
    String name;
    @OneToMany
    @ToString.Exclude
    List<Patient> patientList;
    Specialty specialty;

    public void addPatient(Patient patient) {
        patientList.add(patient);
        System.out.println("All good. Added patient: " + patient + "\nTo doctor: " + this);

    }
}