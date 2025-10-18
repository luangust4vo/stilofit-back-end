package com.ifpr.thread.stilofit.models;

import com.ifpr.thread.stilofit.models.enums.DiscountType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Entity
@Table(name = "promotion")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "{validation.name.notblank}")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "discount_type")
    @NotNull(message = "{validation.discountType.notnull}")
    @Enumerated(EnumType.STRING)
    private DiscountType discountType;

    @Column(name = "value")
    @NotNull(message = "{validation.value.notnull}")
    @Positive(message = "{validation.value.positive}")
    private Double value;

    @Column(name = "times_applied")
    @NotNull(message = "{validation.timesApplied.notnull}")
    @Positive(message = "{validation.timesApplied.positive}")
    private Integer timesApplied;
}
