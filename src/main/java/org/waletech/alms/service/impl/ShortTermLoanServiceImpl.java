package org.waletech.alms.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.waletech.alms.entity.ShortTermLoan;
import org.waletech.alms.repository.ShortTermLoanRepository;
import org.waletech.alms.service.ShortTermLoanService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ShortTermLoanServiceImpl implements ShortTermLoanService {

    private final ShortTermLoanRepository shortTermLoanRepository;

    /**
     * Save or update a short-term loan.
     *
     * @param shortTermLoan the loan to save or update.
     * @return the saved or updated loan.
     */
    @Override
    public ShortTermLoan saveOrUpdateShortTermLoan(ShortTermLoan shortTermLoan) {
        return shortTermLoanRepository.save(shortTermLoan);
    }

    /**
     * Retrieve all short-term loans.
     *
     * @return a list of all short-term loans.
     */
    @Override
    public List<ShortTermLoan> getAllShortTermLoans() {
        return shortTermLoanRepository.findAll();
    }

    /**
     * Retrieve a short-term loan by its ID.
     *
     * @param id the ID of the loan to retrieve.
     * @return the found loan or null if no loan with the given ID exists.
     */
    @Override
    public ShortTermLoan getShortTermLoanById(Long id) {
        return shortTermLoanRepository.findById(id).orElse(null);
    }

    /**
     * Delete a short-term loan by its ID.
     *
     * @param id the ID of the loan to delete.
     */
    @Override
    public void deleteShortTermLoanById(Long id) {
        shortTermLoanRepository.deleteById(id);
    }

    /**
     * Logic to calculate the total credit amount for all short-term loans.
     *
     * @return the total credit amount.
     */
    @Override
    public BigDecimal getTotalCreditAmount() {
        List<ShortTermLoan> loans = shortTermLoanRepository.findAll();
        return loans.stream()
            .map(ShortTermLoan::getCreditAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Logic to determine short-term loans with an interest rate above a given threshold.
     *
     * @param rateThreshold the interest rate threshold.
     * @return a list of short-term loans with interest rates above the given threshold.
     */
    @Override
    public List<ShortTermLoan> getHighInterestShortTermLoans(BigDecimal rateThreshold) {
        return shortTermLoanRepository.findAll().stream()
            .filter(loan -> loan.getInterestRate().compareTo(rateThreshold) > 0)
            .collect(Collectors.toList());
    }

    @Override
    public List<ShortTermLoan> getAllShortTermLoansWithinDays(Long first, Long second) {
        LocalDate startDate = LocalDate.now().plusDays(first);
        LocalDate endDate = LocalDate.now().plusDays(second);
        return shortTermLoanRepository.findAllByNextInterestDateBetween(startDate, endDate);
    }

}
