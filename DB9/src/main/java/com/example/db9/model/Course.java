package com.example.db9.model;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String subject;
    private Integer creditPoints;

    @ManyToOne
    private Specialty specialty;

    @ManyToOne
    private Professor professor;
}