package com.pmv_application.controller;

import com.pmv_application.model.dao.VehicleDao;
import com.pmv_application.model.dto.ManagerInferfaceDto;
import com.pmv_application.model.dto.PageList;
import com.pmv_application.model.dto.PagingRequest;
import com.pmv_application.repository.ManagerInterfaceRep;
//import com.pmv_application.service.ManagerInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManagerInterfaceController {
    @Autowired
    private ManagerInterfaceRep managerInterfaceRep;


    @GetMapping("/GetMonthlyDetailsOfAllCar")
    public List<ManagerInferfaceDto> managerInferfaceDtos(){
        return managerInterfaceRep.getAllVehicleDetailsList();
    }
}
