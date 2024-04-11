package com.pmv_application.converters;

import com.pmv_application.model.dao.ServiceTicketDao;
import com.pmv_application.model.dto.ServiceTicketDto;
import org.springframework.stereotype.Component;

@Component
public class ServiceTicketConverter {
    public ServiceTicketDao toServiceTicketDao(ServiceTicketDto serviceTicketDto) {
        ServiceTicketDao serviceTicketDao = new ServiceTicketDao();
        serviceTicketDao.setId(serviceTicketDto.getId());
        serviceTicketDao.setVehicleid(serviceTicketDto.getVehicleid());
        serviceTicketDao.setLastServiceMileage(serviceTicketDto.getLastServiceMileage());
        serviceTicketDao.setLastServiceDate(serviceTicketDto.getUpcomingServiceDate());
        serviceTicketDao.setServiceDescription(serviceTicketDto.getServiceDescription());
        serviceTicketDao.setServiceCost(serviceTicketDto.getServiceCost());
        serviceTicketDao.setUpcomingServiceDate(serviceTicketDto.getUpcomingServiceDate());
        serviceTicketDao.setServiceEngineerName(serviceTicketDto.getServiceEngineerName());
        return serviceTicketDao;
    }
    public ServiceTicketDto toServiceTicketDto(ServiceTicketDao serviceTicketDao) {
        ServiceTicketDto serviceTicketDto = new ServiceTicketDto();
        serviceTicketDto.setId(serviceTicketDao.getId());
        serviceTicketDto.setVehicleid(serviceTicketDao.getVehicleid());
        serviceTicketDto.setLastServiceMileage(serviceTicketDao.getLastServiceMileage());
        serviceTicketDto.setLastServiceDate(serviceTicketDao.getUpcomingServiceDate());
        serviceTicketDto.setServiceDescription(serviceTicketDao.getServiceDescription());
        serviceTicketDto.setServiceCost(serviceTicketDao.getServiceCost());
        serviceTicketDto.setUpcomingServiceDate(serviceTicketDao.getUpcomingServiceDate());
        serviceTicketDto.setServiceEngineerName(serviceTicketDao.getServiceEngineerName());
        return serviceTicketDto;
    }
}
