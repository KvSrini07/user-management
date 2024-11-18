package com.erp.userms.repository;

import com.erp.userms.entity.ApiPermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiPermissionRepository extends JpaRepository<ApiPermissionEntity,Long> {
    boolean existsByName(String name);

}
