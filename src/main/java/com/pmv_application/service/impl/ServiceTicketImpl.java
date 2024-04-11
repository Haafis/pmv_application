package com.pmv_application.service.impl;

import com.pmv_application.converters.ServiceTicketConverter;
import com.pmv_application.model.dao.ServiceTicketDao;
import com.pmv_application.model.dao.VehicleDao;
import com.pmv_application.model.dto.*;
import com.pmv_application.repository.ServiceTicketRepository;
import com.pmv_application.service.ServiceTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceTicketImpl implements ServiceTicketService {

    @Autowired
    private ServiceTicketRepository serviceTicketRepository;
    @Autowired
    private ServiceTicketConverter serviceTicketConverter;



    @Override
    public void SubmitServiceTicket(ServiceTicketDto serviceTicketDto) {
        if (serviceTicketDto.getId() == 0) {
            ServiceTicketDao serviceTicketDao = serviceTicketConverter.toServiceTicketDao(serviceTicketDto);
            serviceTicketRepository.save(serviceTicketDao);
        } else {
            ServiceTicketDao serviceTicketDao = serviceTicketRepository.findById(serviceTicketDto.getId()).get();
            serviceTicketDao.setLastServiceMileage(serviceTicketDto.getLastServiceMileage());
            serviceTicketDao.setLastServiceDate(serviceTicketDto.getLastServiceDate());
            serviceTicketDao.setServiceDescription(serviceTicketDto.getServiceDescription());
            serviceTicketDao.setServiceCost(serviceTicketDto.getServiceCost());
            serviceTicketDao.setUpcomingServiceDate(serviceTicketDto.getUpcomingServiceDate());
            serviceTicketRepository.save(serviceTicketDao);
        }

    }

    @Override
    public PageList<ServiceTicketDao> getAllServiceTicketDetails(PagingRequest pagingRequest) {
        try {
            int pageNumber = 0;
            if (pagingRequest.getStart() > 0) {
                pageNumber = pagingRequest.getStart() / pagingRequest.getLength();
            }
            Pageable pageable = PageRequest.of(pageNumber, pagingRequest.getLength());
            String searchValue = pagingRequest.getSearch().getValue();
            Page<ServiceTicketDao> pagedResult;
            pagedResult = serviceTicketRepository.findAll(pageable);
            List<ServiceTicketDao> masterDAOList = pagedResult.getContent();

            List<ServiceTicketDao> filtered = masterDAOList.stream().collect(Collectors.toList());
            PageList<ServiceTicketDao> pageList = new PageList<>(filtered);
            pageList.setRecordsFiltered((int) pagedResult.getTotalElements());
            pageList.setRecordsTotal((int) pagedResult.getTotalElements());
            pageList.setDraw(pagingRequest.getDraw());
            return pageList;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ServiceTicketDto getserviceTicketByID(Integer id) {
        ServiceTicketDao serviceTicketDao = serviceTicketRepository.getById(id);
        ServiceTicketDto serviceTicketDto = serviceTicketConverter.toServiceTicketDto(serviceTicketDao);
        return serviceTicketDto;
    }

    @Override
    public ServerMessageDto deleteserviceTicketByID(Integer id) {
        ServerMessageDto serverMessageDto = new ServerMessageDto();
        try {
            serviceTicketRepository.deleteById(id);
            serverMessageDto.setSuccessFlag(1);
        } catch (Exception e) {
            serverMessageDto.setSuccessFlag(0);
        }
        return serverMessageDto;
    }
}
