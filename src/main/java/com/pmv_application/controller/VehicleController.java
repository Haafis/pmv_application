package com.pmv_application.controller;

import com.pmv_application.model.dao.VehicleDao;
import com.pmv_application.model.dto.PageList;
import com.pmv_application.model.dto.PagingRequest;
import com.pmv_application.model.dto.ServerMessageDto;
import com.pmv_application.model.dto.VehicleDto;
import com.pmv_application.repository.VehicleRepository;
import com.pmv_application.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private VehicleService vehicleService;


    @PostMapping("/addVehicleDetails")
    public ResponseEntity<String> addNewCar(@RequestBody VehicleDto vehicleDto) {
        try {
                vehicleService.SaveVehicle(vehicleDto);
                return new ResponseEntity<>("Vehicle Added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //   @Secured({"ADMIN"})
    @PostMapping("/getAllvehicleDetails")
    public PageList<VehicleDao> pageList(@RequestBody PagingRequest pagingRequest) {
        PageList<VehicleDao> pageList = vehicleService.getAllVehicleList(pagingRequest);
        return pageList;
    }

    @GetMapping("/getVehicleDetailsByID")
    public VehicleDto getVehicleDetailsByID(@RequestParam("vehicleid") Integer id) {
        return vehicleService.getVehicleDetailsByID(id);
    }

    @DeleteMapping("/deleteVehicleDetailsByID")
    public ServerMessageDto deleteVehicleDetailsByID(@RequestParam("vehicleid") Integer id) {
        ServerMessageDto serverMessageDto = vehicleService.deleteVehicleDetailsByID(id);
        return serverMessageDto;
    }

}
