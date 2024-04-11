package com.pmv_application.model.dao;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Entity
@Data
@Table(name = "servicet_ticket ")
public class ServiceTicketDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private Integer vehicleid;
    private Integer lastServiceMileage;
    private Date lastServiceDate;
    private String serviceDescription;
    private double serviceCost;
    private Date upcomingServiceDate;
    private String serviceEngineerName;
}
