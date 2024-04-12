package com.pmv_application.repository;
import com.pmv_application.model.dao.VehicleDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VehicleRepository extends JpaRepository<VehicleDao, Integer> {

}


