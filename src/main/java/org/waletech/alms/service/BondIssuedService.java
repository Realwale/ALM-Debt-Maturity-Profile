package org.waletech.alms.service;


import org.waletech.alms.entity.BondIssued;

import java.math.BigDecimal;
import java.util.List;

public interface BondIssuedService{

    BondIssued saveOrUpdateBondIssued(BondIssued bondIssued);

    List<BondIssued> getAllBondsIssued();

    BondIssued getBondIssuedById(Long id);

    void deleteBondIssuedById(Long id);

    BigDecimal getTotalFaceValue();

    List<BondIssued> getHighCouponRateBonds(BigDecimal rateThreshold);

    List<BondIssued> getAllBondIssuedsWithinDays(Long first, Long second);
}