package com.pmv_application.repository;

import com.pmv_application.model.dao.UserDao;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserDao, Integer> {
    @Query(value = "SELECT username, password, role FROM users WHERE role = :loginRole AND username = :loginUsername", nativeQuery = true)
    List<Object[]> getLoginUsernameAndPassword(@Param("loginRole") String loginRole, @Param("loginUsername") String loginUsername);
}

