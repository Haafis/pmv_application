package com.pmv_application.controller;
import com.pmv_application.model.dto.DriverDto;
import com.pmv_application.model.dto.ManagerInferfaceDto;
import com.pmv_application.repository.DriverRepo;
import com.pmv_application.repository.ManagerInterfaceRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DriverController {
    @Autowired
    private DriverRepo driverRepo;


    @GetMapping("/GetVehicleHistory")
    public List<DriverDto> managerInferfaceDtos(){
        return driverRepo.getVehicleHistory();
    }
}
