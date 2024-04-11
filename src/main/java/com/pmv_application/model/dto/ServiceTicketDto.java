package com.pmv_application.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ServiceTicketDto {
    private Integer id;
    private Integer vehicleid;
    private Integer lastServiceMileage;
    private Date lastServiceDate;
    private String serviceDescription;
    private double serviceCost;
    private Date upcomingServiceDate;
    private String serviceEngineerName;
}
