package org.waletech.alms.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.waletech.alms.entity.CommercialPaper;
import org.waletech.alms.repository.CommercialPaperRepository;
import org.waletech.alms.service.CommercialPaperService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CommercialPaperServiceImpl implements CommercialPaperService {

    private final CommercialPaperRepository commercialPaperRepository;

    /**
     * Save or update a commercial paper.
     *
     * @param commercialPaper the paper to save or update.
     * @return the saved or updated paper.
     */

    @Override
    public CommercialPaper saveOrUpdateCommercialPaper(CommercialPaper commercialPaper) {
        return commercialPaperRepository.save(commercialPaper);
    }

    /**
     * Retrieve all commercial papers.
     *
     * @return a list of all commercial papers.
     */

    @Override
    public List<CommercialPaper> getAllCommercialPapers() {
        return commercialPaperRepository.findAll();
    }

    /**
     * Retrieve a commercial paper by its ID.
     *
     * @param id the ID of the paper to retrieve.
     * @return the found paper or null if no paper with the given ID exists.
     */
    @Override
    public CommercialPaper getCommercialPaperById(Long id) {
        return commercialPaperRepository.findById(id).orElse(null);
    }

    /**
     * Delete a commercial paper by its ID.
     *
     * @param id the ID of the paper to delete.
     */
    @Override
    public void deleteCommercialPaperById(Long id) {
        commercialPaperRepository.deleteById(id);
    }

    /**
     * Logic to calculate the total amount for all commercial papers.
     *
     * @return the total amount.
     */
    @Override
    public BigDecimal getTotalAmount() {
        List<CommercialPaper> papers = commercialPaperRepository.findAll();
        return papers.stream()
            .map(CommercialPaper::getAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Logic to determine commercial papers with a discount rate above a given threshold.
     *
     * @param rateThreshold the discount rate threshold.
     * @return a list of commercial papers with discount rates above the given threshold.
     */
    @Override
    public List<CommercialPaper> getHighDiscountRatePapers(BigDecimal rateThreshold) {
        return commercialPaperRepository.findAll().stream()
            .filter(paper -> paper.getDiscountRate().compareTo(rateThreshold) > 0)
            .collect(Collectors.toList());
    }

    @Override
    public List<CommercialPaper> getAllCommercialPapersWithinDays(Long first, Long second) {
        LocalDate startDate = LocalDate.now().plusDays(first);
        LocalDate endDate = LocalDate.now().plusDays(second);
        return commercialPaperRepository.findAllByMaturityDateBetween(startDate, endDate);
    }

}
