package com.pmv_application.controller;

import com.pmv_application.model.dao.ServiceTicketDao;
import com.pmv_application.model.dto.*;
import com.pmv_application.repository.ServiceTicketRepository;
import com.pmv_application.service.ServiceTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/service-tickets")
public class ServiceTicketController {
    @Autowired
    private ServiceTicketRepository serviceTicketRepository;

    @Autowired
    private ServiceTicketService serviceTicketService;

    @PostMapping("/submit")
    public String createServiceTicket(@RequestBody ServiceTicketDto serviceTicketDto) {
        try {
            serviceTicketService.SubmitServiceTicket(serviceTicketDto);
            return "Submitted Successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PostMapping("/getAllServiceTicketDetails")
    public PageList<ServiceTicketDao> pageList(@RequestBody PagingRequest pagingRequest) {
        PageList<ServiceTicketDao> pageList = serviceTicketService.getAllServiceTicketDetails(pagingRequest);
        return pageList;
    }

    @GetMapping("/getserviceTicketByID")
    public ServiceTicketDto getserviceTicketByID(@RequestParam("id") Integer id) {
        return serviceTicketService.getserviceTicketByID(id);
    }

    @DeleteMapping("/deleteserviceTicketByID")
    public ServerMessageDto deleteserviceTicketByID(@RequestParam("id") Integer id) {
        ServerMessageDto serverMessageDto = serviceTicketService.deleteserviceTicketByID(id);
        return serverMessageDto;
    }
}
