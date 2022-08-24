package com.example.db9.model;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String project;

    @ManyToOne
    Professor professor;


}