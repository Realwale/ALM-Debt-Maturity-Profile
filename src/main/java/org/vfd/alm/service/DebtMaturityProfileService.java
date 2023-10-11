package org.vfd.alm.service;

import jakarta.transaction.Transactional;
import org.springframework.data.util.Pair;
import org.vfd.alm.dto.DebtMaturityResponseDTO;

import java.math.BigDecimal;
import java.util.Map;

public interface DebtMaturityProfileService {

    @Transactional
    DebtMaturityResponseDTO computeAndSaveDebtMaturityProfileForBucket(String bucket);

    Pair<Long, Long> determineDaysRangeForBucket(String bucket);
}
