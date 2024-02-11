package org.waletech.alms.service;

import org.waletech.alms.entity.ShortTermLoan;

import java.math.BigDecimal;
import java.util.List;

public interface ShortTermLoanService {
    ShortTermLoan saveOrUpdateShortTermLoan(ShortTermLoan shortTermLoan);

    List<ShortTermLoan> getAllShortTermLoans();

    ShortTermLoan getShortTermLoanById(Long id);

    void deleteShortTermLoanById(Long id);

    BigDecimal getTotalCreditAmount();

    List<ShortTermLoan> getHighInterestShortTermLoans(BigDecimal rateThreshold);

    List<ShortTermLoan> getAllShortTermLoansWithinDays(Long first, Long second);
}
