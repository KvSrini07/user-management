package com.erp.userms.repository;

import com.erp.userms.entity.OrganizationSubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrganizationSubscriptionRepo extends JpaRepository<OrganizationSubscriptionEntity,Long> {
}
