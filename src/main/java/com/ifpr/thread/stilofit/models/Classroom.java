package com.ifpr.thread.stilofit.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Entity
@Table(name = "classrooms")
@Data 
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "vacancies", nullable = false)
    private Integer vacancies; 

    @Column(name = "duration_minutes", nullable = false)
    private Integer durationMinutes;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "observations", columnDefinition = "TEXT")
    private String observations;

    @Column(name = "color_hex")
    private String colorHex;

    @ManyToMany(mappedBy = "classrooms") 
    private Set<Contract> contracts;
}