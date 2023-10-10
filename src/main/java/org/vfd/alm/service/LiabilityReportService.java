package org.vfd.alm.service;

import org.vfd.alm.entity.LiabilityReport;

import java.math.BigDecimal;
import java.util.List;

public interface LiabilityReportService {
    LiabilityReport saveOrUpdateLiabilityReport(LiabilityReport liabilityReport);

    List<LiabilityReport> getAllLiabilityReports();

    LiabilityReport getLiabilityReportById(Long id);

    void deleteLiabilityReportById(Long id);

    BigDecimal getTotalFaceAmount();

    List<LiabilityReport> getLiabilitiesMaturingNextMonth();

    List<LiabilityReport> getAllLiabilityReportsWithinDays(Long first, Long second);
}
