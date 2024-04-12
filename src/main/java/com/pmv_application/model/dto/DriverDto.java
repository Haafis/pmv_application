package com.pmv_application.model.dto;

import lombok.Data;

@Data
public class DriverDto {
    private String lastservicedate;
    private String ServiceType;
    private String Mechanic;
    private String Cost;
    private String upcomingservicedate;
}
