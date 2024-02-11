package org.waletech.alms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.waletech.alms.entity.DebtMaturityProfile;

public interface DebtMaturityProfileRepository extends JpaRepository<DebtMaturityProfile, Long> {
    void deleteByBucket(String bucket);
}
