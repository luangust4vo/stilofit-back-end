package com.ifpr.thread.stilofit.dto.list;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AgreementListDTO extends DiscountListDTO {
    private Integer partnersMinimum;
}
