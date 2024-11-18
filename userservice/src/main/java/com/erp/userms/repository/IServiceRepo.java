package com.erp.userms.repository;

import com.erp.userms.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceRepo extends JpaRepository<ServiceEntity, Long> {

    boolean existsByServiceId(Long serviceId);

    boolean existsByServiceName(String serviceName);

}
