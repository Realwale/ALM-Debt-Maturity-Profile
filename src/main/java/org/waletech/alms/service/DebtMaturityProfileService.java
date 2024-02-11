package org.waletech.alms.service;

import jakarta.transaction.Transactional;
import org.springframework.data.util.Pair;
import org.waletech.alms.dto.DebtMaturityResponseDTO;



public interface DebtMaturityProfileService {

    @Transactional
    DebtMaturityResponseDTO computeAndSaveDebtMaturityProfileForBucket(String bucket);

    Pair<Long, Long> determineDaysRangeForBucket(String bucket);
}
