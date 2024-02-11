package org.waletech.alms.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.waletech.alms.entity.OverdraftAccount;
import org.waletech.alms.repository.OverdraftAccountRepository;
import org.waletech.alms.service.OverdraftAccountService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OverdraftAccountServiceImpl implements OverdraftAccountService {

    private final OverdraftAccountRepository overdraftAccountRepository;

    /**
     * Save or update an overdraft account.
     *
     * @param overdraftAccount the account to save or update.
     * @return the saved or updated account.
     */
    @Override
    public OverdraftAccount saveOrUpdateOverdraftAccount(OverdraftAccount overdraftAccount) {
        return overdraftAccountRepository.save(overdraftAccount);
    }

    /**
     * Retrieve all overdraft accounts.
     *
     * @return a list of all overdraft accounts.
     */
    @Override
    public List<OverdraftAccount> getAllOverdraftAccounts() {
        return overdraftAccountRepository.findAll();
    }

    /**
     * Retrieve an overdraft account by its ID.
     *
     * @param id the ID of the account to retrieve.
     * @return the found account or null if no account with the given ID exists.
     */
    @Override
    public OverdraftAccount getOverdraftAccountById(Long id) {
        return overdraftAccountRepository.findById(id).orElse(null);
    }

    /**
     * Delete an overdraft account by its ID.
     *
     * @param id the ID of the account to delete.
     */
    @Override
    public void deleteOverdraftAccountById(Long id) {
        overdraftAccountRepository.deleteById(id);
    }

    /**
     * Logic to calculate the total outstanding balance for all overdraft accounts.
     *
     * @return the total outstanding balance.
     */
    @Override
    public BigDecimal getTotalOutstandingBalance() {
        List<OverdraftAccount> accounts = overdraftAccountRepository.findAll();
        return accounts.stream()
            .map(OverdraftAccount::getOutstandingBalance)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Logic to determine overdraft accounts with an interest rate above a given threshold.
     *
     * @param rateThreshold the interest rate threshold.
     * @return a list of overdraft accounts with interest rates above the given threshold.
     */
    @Override
    public List<OverdraftAccount> getHighInterestOverdraftAccounts(BigDecimal rateThreshold) {
        return overdraftAccountRepository.findAll().stream()
            .filter(account -> account.getInterestRate().compareTo(rateThreshold) > 0)
            .collect(Collectors.toList());
    }

    @Override
    public List<OverdraftAccount> getAllOverdraftAccountsWithinDays(Long first, Long second) {
        LocalDate startDate = LocalDate.now().plusDays(first);
        LocalDate endDate = LocalDate.now().plusDays(second);
        return overdraftAccountRepository.findAllByRecyclingDateBetween(startDate, endDate);
    }

}
