package com.ifpr.thread.stilofit.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String status;
    private String template;
    private String installmentable;
    private Integer installments;
    private Double totalValue;
    private Double installmentsValue;
    private Integer expire;
    private String typeExpire;

    @ElementCollection
    private List<String> classRoms;

    private String timeMin;
    private String timeMax;

    @ElementCollection
    private List<String> weekdays;
}