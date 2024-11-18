package com.erp.userms.repository;

import com.erp.userms.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepo extends JpaRepository<AddressEntity,Long> {
}
