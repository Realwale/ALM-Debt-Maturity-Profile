package org.vfd.alm.service;

import org.vfd.alm.entity.CommercialPaper;

import java.math.BigDecimal;
import java.util.List;

public interface CommercialPaperService {

    CommercialPaper saveOrUpdateCommercialPaper(CommercialPaper commercialPaper);

    List<CommercialPaper> getAllCommercialPapers();

    CommercialPaper getCommercialPaperById(Long id);

    void deleteCommercialPaperById(Long id);

    BigDecimal getTotalAmount();

    List<CommercialPaper> getHighDiscountRatePapers(BigDecimal rateThreshold);

    List<CommercialPaper> getAllCommercialPapersWithinDays(Long first, Long second);
}
