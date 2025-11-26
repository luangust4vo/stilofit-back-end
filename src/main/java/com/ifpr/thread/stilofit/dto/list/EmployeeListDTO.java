package com.ifpr.thread.stilofit.dto.list;

import com.ifpr.thread.stilofit.models.enums.Role;
import com.ifpr.thread.stilofit.models.enums.Shift;
import com.ifpr.thread.stilofit.models.enums.Status;

import lombok.Data;

@Data
public class EmployeeListDTO {
    private Long id;
    private String name;
    private Role role;
    private Status status;
    private Shift shift;
}
