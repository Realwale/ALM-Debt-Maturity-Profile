package org.vfd.alm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vfd.alm.entity.LiabilityReport;

public interface LiabilityReportRepository extends JpaRepository<LiabilityReport, Long> {
    // You can add custom queries here if needed
}
