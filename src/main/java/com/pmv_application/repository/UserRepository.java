package com.pmv_application.repository;

import com.pmv_application.model.dao.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDao,Integer> {
    UserDao findByUsername(String username);
}
