package com.pmv_application.repository;
import com.pmv_application.model.dto.DriverDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DriverRepo {
    @Autowired
    private EntityManager entityManager;

    public List<DriverDto> getVehicleHistory(){
        Query query=entityManager.createNativeQuery("SELECT \n" +
                "    to_char(last_service_date, 'DD-MM-YYYY HH24:MI:SS') AS lastservicedate,\n" +
                "    service_description as ServiceType, \n" +
                "    service_engineer_name as Mechanic, \n" +
                "    ' ' as Cost, \n" +
                "    upcoming_service_date as upcomingservicedate\n" +
                "FROM \n" +
                "    servicet_ticket\n" +
                "GROUP BY \n" +
                "    service_description,\n" +
                "    service_engineer_name,\n" +
                "    last_service_date,\n" +
                "    upcoming_service_date;\n");
        List<Object[]>list=query.getResultList();
        List<DriverDto>driverDtos = new ArrayList<>();
        for (Object[] ob:list
        ) {
            DriverDto driverDto = new DriverDto();
            driverDto.setLastservicedate(ob[0].toString());
            driverDto.setServiceType(ob[1].toString());
            driverDto.setMechanic(ob[2].toString());
            driverDto.setCost(ob[3].toString());
            driverDto.setUpcomingservicedate(ob[4].toString());
            driverDtos.add(driverDto);
        }
        return driverDtos;
    }
}



