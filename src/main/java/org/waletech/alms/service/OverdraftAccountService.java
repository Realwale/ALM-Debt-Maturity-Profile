package org.waletech.alms.service;

import org.waletech.alms.entity.OverdraftAccount;

import java.math.BigDecimal;
import java.util.List;

public interface OverdraftAccountService {
    OverdraftAccount saveOrUpdateOverdraftAccount(OverdraftAccount overdraftAccount);

    List<OverdraftAccount> getAllOverdraftAccounts();

    OverdraftAccount getOverdraftAccountById(Long id);

    void deleteOverdraftAccountById(Long id);

    BigDecimal getTotalOutstandingBalance();

    List<OverdraftAccount> getHighInterestOverdraftAccounts(BigDecimal rateThreshold);

    List<OverdraftAccount> getAllOverdraftAccountsWithinDays(Long first, Long second);
}
