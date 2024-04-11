package com.pmv_application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String Dashboard(){
        return "/pages/Dashboard";
    }
    @RequestMapping("/login")
    public String login(){
        return "/pages/login";
    }
//    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/AddVehicle")
    public String AddVehicle(){
        return "/pages/AddVehicle";
    }

    @RequestMapping("/ServiceTicket")
    public String SubmitServiceTicket(){
        return "/pages/ServiceTicket";
    }

//    @RequestMapping("/CreateServiceTicket")
//    public String CreateServiceTicket(){
//        return "/pages/CreateServiceTicket";
//    }

    @RequestMapping(value = "/CreateServiceTicket", params = "id")
    public String CreateServiceTicket(@RequestParam("id") Integer id, Model model){
        model.addAttribute("id", id);
        return "/pages/CreateServiceTicket";
    }

    @RequestMapping("/DriverServiceTickets")
    public String DriverServiceTickets(){
        return "/pages/DriverServiceTickets";
    }
    @RequestMapping("/ManagerInterface")
    public String ManagerInterface(){
        return "/pages/ManagerInterface";
    }
}
