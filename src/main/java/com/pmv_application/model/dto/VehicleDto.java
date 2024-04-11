package com.pmv_application.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class VehicleDto {
    private Integer vehicleid;
    private String plateNo;
    private String model;
    private Integer manufacturingYear;
    private Date upcomingServiceDate;
    private String driverinformation;
    ;
}
