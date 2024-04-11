package com.pmv_application.model.dao;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "vehicle")
public class VehicleDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer vehicleid;
    @Column(name = "plate_no")
    private String plateNo;
    @Column(name = "model")
    private String model;
    @Column(name = "manufacturing_year")
    private Integer manufacturingYear;
    @Column(name = "upcoming_service_date")
    private Date upcomingServiceDate;
    @Column(name = "driverinformation")
    private String driverinformation;
}
