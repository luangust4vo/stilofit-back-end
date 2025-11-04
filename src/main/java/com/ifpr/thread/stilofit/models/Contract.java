package com.ifpr.thread.stilofit.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "contract")
@Data
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

    @Column(name = "template", columnDefinition = "TEXT")
    private String template;

    @Column(name = "installmentable", nullable = false, length = 10)
    private String installmentable;

    @Column(name = "installments")
    private Integer installments;

    @Column(name = "total_value")
    private Double totalValue;

    @Column(name = "installment_value")
    private Double installmentsValue;

    @Column(name = "expire")
    private Integer expire;

    @Column(name = "type_expire", length = 20)
    private String typeExpire;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "contract_classroom_join", // Tabela de junção para o @ManyToMany
        joinColumns = @JoinColumn(name = "contract_id"),
        inverseJoinColumns = @JoinColumn(name = "classroom_id")
    )
    private Set<Classroom> classrooms;

    @Column(name = "time_min", length = 10)
    private String timeMin;

    @Column(name = "time_max", length = 10)
    private String timeMax;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "weekdays_id", referencedColumnName = "id")
    private WeekDays weekdays;
}