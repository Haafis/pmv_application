package com.pmv_application.converters;
import com.pmv_application.model.dao.VehicleDao;
import com.pmv_application.model.dto.VehicleDto;
import org.springframework.stereotype.Component;
@Component
public class VehicleConverters {

    public VehicleDao toVehicleDao(VehicleDto vehicleDto) {
        VehicleDao vehicleDao = new VehicleDao();
        vehicleDao.setVehicleid(vehicleDto.getVehicleid());
        vehicleDao.setPlateNo(vehicleDto.getPlateNo());
        vehicleDao.setModel(vehicleDto.getModel());
        vehicleDao.setManufacturingYear(vehicleDto.getManufacturingYear());
        vehicleDao.setUpcomingServiceDate(vehicleDto.getUpcomingServiceDate());
        vehicleDao.setDriverinformation(vehicleDto.getDriverinformation());
        return vehicleDao;
    }

    public VehicleDto toVehicleDto(VehicleDao vehicleDao) {
        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setVehicleid(vehicleDao.getVehicleid());
        vehicleDto.setPlateNo(vehicleDao.getPlateNo());
        vehicleDto.setModel(vehicleDao.getModel());
        vehicleDto.setManufacturingYear(vehicleDao.getManufacturingYear());
        vehicleDto.setUpcomingServiceDate(vehicleDao.getUpcomingServiceDate());
        vehicleDto.setDriverinformation(vehicleDao.getDriverinformation());
        return vehicleDto;
    }
}
