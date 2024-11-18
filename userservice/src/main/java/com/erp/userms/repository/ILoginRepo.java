package com.erp.userms.repository;

import com.erp.userms.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoginRepo extends JpaRepository<LoginEntity,Long> {

    LoginEntity findByUsername(String username);

    boolean existsByUsername(String username);
}
