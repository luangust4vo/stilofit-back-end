package com.ifpr.thread.stilofit.models;

import com.ifpr.thread.stilofit.models.enums.AgreementStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "agreement")
@EqualsAndHashCode(callSuper = true)
public class Agreement extends Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "partners_minimum")
    @NotNull(message = "{validation.partnersMinimum.notnull}")
    @Positive(message = "{validation.partnersMinimum.positive}")
    private Integer partnersMinimum;

    @Column(name = "agreement_status")
    @NotNull(message = "{validation.agreementStatus.notnull}")
    @Enumerated(EnumType.STRING)
    private AgreementStatus agreementStatus = AgreementStatus.INACTIVE;

}
