package org.vfd.alm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vfd.alm.entity.DebtMaturityProfile;

public interface DebtMaturityProfileRepository extends JpaRepository<DebtMaturityProfile, Long> {
    void deleteByBucket(String bucket);
}
