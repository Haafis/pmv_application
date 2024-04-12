package com.pmv_application.repository;
import com.pmv_application.model.dto.ManagerInferfaceDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ManagerInterfaceRep {
    @Autowired
    private EntityManager entityManager;

    public List<ManagerInferfaceDto> getAllVehicleDetailsList(){
        Query query=entityManager.createNativeQuery("SELECT \n" +
                "    COALESCE(vc.model,'N/A') AS model, \n" +
                "    COUNT(sc.vehicleid) AS count, \n" +
                "    sc.last_service_date AS lastservicedate, \n" +
                "    sc.service_cost AS servicecost, \n" +
                "    sc.last_service_mileage AS lastservicemileage \n" +
                "FROM \n" +
                "    servicet_ticket sc \n" +
                "LEFT JOIN \n" +
                "    vehicle vc ON sc.vehicleid = vc.vehicleid \n" +
                "GROUP BY \n" +
                "    vc.model, sc.last_service_date, sc.service_cost, sc.last_service_mileage;\n");
        List<Object[]>list=query.getResultList();
        List<ManagerInferfaceDto>managerInferfaceDtos=new ArrayList<>();
        for (Object[] ob:list
             ) {
            ManagerInferfaceDto managerInferfaceDto=new ManagerInferfaceDto();
            managerInferfaceDto.setModel(ob[0].toString());
            managerInferfaceDto.setCount(ob[1].toString());
            managerInferfaceDto.setLastservicedate(ob[2].toString());
            managerInferfaceDto.setServicecost(ob[3].toString());
            managerInferfaceDto.setLastservicemileage(ob[4].toString());
            managerInferfaceDtos.add(managerInferfaceDto);
        }
        return managerInferfaceDtos;
    }
}



