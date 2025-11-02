package com.ifpr.thread.stilofit.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @ElementCollection
    @CollectionTable(
        name = "contract_classrooms",
        joinColumns = @JoinColumn(name = "contract_id")
    )
    @Column(name = "classroom", length = 100)
    private List<String> classRoms;

    @Column(name = "time_min", length = 10)
    private String timeMin;

    @Column(name = "time_max", length = 10)
    private String timeMax;

    @ElementCollection
    @CollectionTable(
        name = "contract_weekdays",
        joinColumns = @JoinColumn(name = "contract_id")
    )
    @Column(name = "weekday", length = 20)
    private List<String> weekdays;
}