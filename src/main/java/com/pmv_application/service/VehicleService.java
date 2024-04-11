package com.pmv_application.service;
import com.pmv_application.model.dao.VehicleDao;
import com.pmv_application.model.dto.PageList;
import com.pmv_application.model.dto.PagingRequest;
import com.pmv_application.model.dto.ServerMessageDto;
import com.pmv_application.model.dto.VehicleDto;


public interface VehicleService {
    public void SaveVehicle(VehicleDto vehicleDto);

    public PageList<VehicleDao> getAllVehicleList(PagingRequest request);

    public VehicleDto getVehicleDetailsByID(Integer id);

    public ServerMessageDto deleteVehicleDetailsByID(Integer id);


}
