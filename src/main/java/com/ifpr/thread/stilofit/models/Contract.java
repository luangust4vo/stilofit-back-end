package com.ifpr.thread.stilofit.models;

import java.time.LocalTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

import com.ifpr.thread.stilofit.models.enums.ContractStatus;
import com.ifpr.thread.stilofit.models.enums.TypeExpire;

@Entity
@Table(name = "contract")
@Data
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 100)
    @NotBlank(message = "{validation.name.notblank}")
    private String name;

    @Column(name = "status")
    @NotNull(message = "{validation.status.notnull}")
    @Enumerated(EnumType.STRING)
    private ContractStatus status;

    @Column(name = "template", columnDefinition = "TEXT")
    @NotBlank(message = "{validation.template.notblank}")
    private String template;

    @Column(name = "installmentable", length = 10)
    @NotNull(message = "{validation.installmentable.notnull}")
    private boolean installmentable;

    @Column(name = "installments")
    private Integer installments;

    @Column(name = "total_value")
    @NotNull(message = "{validation.total_value.notnull}")
    private Double totalValue;

    @Column(name = "installment_value")
    private Double installmentsValue;

    @Column(name = "expire")
    @NotNull(message = "{validation.expire.notnull}")
    private Integer expire;

    @Column(name = "type_expire", length = 20)
    @NotNull(message = "{validation.typeExpire.notnull}")
    @Enumerated(EnumType.STRING)
    private TypeExpire typeExpire;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "contract_classroom_join", // Tabela de junção para o @ManyToMany
        joinColumns = @JoinColumn(name = "contract_id"),
        inverseJoinColumns = @JoinColumn(name = "classroom_id")
    )
    private Set<Classroom> classrooms;

    @Column(name = "time_min", length = 10)
    private LocalTime timeMin;

    @Column(name = "time_max", length = 10)
    private LocalTime timeMax;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "week_days_id", referencedColumnName = "id")
    private WeekDays weekDays;
}