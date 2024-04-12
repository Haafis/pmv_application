package com.pmv_application.service;

import com.pmv_application.model.dao.ServiceTicketDao;
import com.pmv_application.model.dto.*;


public interface ServiceTicketService {

    public void SubmitServiceTicket(ServiceTicketDto serviceTicketDto);

    public PageList<ServiceTicketDao> getAllServiceTicketDetails(PagingRequest request);

    public ServiceTicketDto getserviceTicketByID(Integer id);

    public ServerMessageDto deleteserviceTicketByID(Integer id);
}
