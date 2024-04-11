package com.pmv_application.repository;

import com.pmv_application.model.dao.ServiceTicketDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceTicketRepository extends JpaRepository<ServiceTicketDao,Integer> {
}
