package com.pmv_application.service.impl;

import com.pmv_application.converters.VehicleConverters;
import com.pmv_application.model.dao.VehicleDao;
import com.pmv_application.model.dto.PageList;
import com.pmv_application.model.dto.PagingRequest;
import com.pmv_application.model.dto.ServerMessageDto;
import com.pmv_application.model.dto.VehicleDto;
import com.pmv_application.repository.VehicleRepository;
import com.pmv_application.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private VehicleConverters vehicleConverters;

    @Override
    public void SaveVehicle(VehicleDto vehicleDto) {
        if (vehicleDto.getVehicleid() == 0) {
            VehicleDao vehicleDao = vehicleConverters.toVehicleDao(vehicleDto);
            vehicleRepository.save(vehicleDao);
        } else {
            VehicleDao vehicleDao1 = vehicleRepository.findById(vehicleDto.getVehicleid()).get();
            vehicleDao1.setPlateNo(vehicleDto.getPlateNo());
            vehicleDao1.setModel(vehicleDto.getModel());
            vehicleDao1.setManufacturingYear(vehicleDto.getManufacturingYear());
            vehicleDao1.setUpcomingServiceDate(vehicleDto.getUpcomingServiceDate());
            vehicleDao1.setDriverinformation(vehicleDto.getDriverinformation());
            vehicleRepository.save(vehicleDao1);
        }

    }

    public PageList<VehicleDao> getAllVehicleList(PagingRequest pagingRequest) {
        try {
            int pageNumber = 0;
            if (pagingRequest.getStart() > 0) {
                pageNumber = pagingRequest.getStart() / pagingRequest.getLength();
            }
            Pageable pageable = PageRequest.of(pageNumber, pagingRequest.getLength());
            String searchValue = pagingRequest.getSearch().getValue();
            Page<VehicleDao> pagedResult;
            pagedResult = vehicleRepository.findAll(pageable);
            List<VehicleDao> masterDAOList = pagedResult.getContent();

            List<VehicleDao> filtered = masterDAOList.stream().collect(Collectors.toList());
            PageList<VehicleDao> pageList = new PageList<>(filtered);
            pageList.setRecordsFiltered((int) pagedResult.getTotalElements());
            pageList.setRecordsTotal((int) pagedResult.getTotalElements());
            pageList.setDraw(pagingRequest.getDraw());
            return pageList;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public VehicleDto getVehicleDetailsByID(Integer id) {
        VehicleDao vehicleDao = vehicleRepository.getById(id);
        VehicleDto vehicleDto = vehicleConverters.toVehicleDto(vehicleDao);
        return vehicleDto;
    }

    @Override
    public ServerMessageDto deleteVehicleDetailsByID(Integer id) {
        ServerMessageDto serverMessageDto = new ServerMessageDto();
        try {
            vehicleRepository.deleteById(id);
            serverMessageDto.setSuccessFlag(1);
        } catch (Exception e) {
            serverMessageDto.setSuccessFlag(0);
        }
        return serverMessageDto;
    }




}


