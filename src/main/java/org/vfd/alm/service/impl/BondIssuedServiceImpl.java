package org.vfd.alm.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vfd.alm.entity.BondIssued;
import org.vfd.alm.repository.BondIssuedRepository;
import org.vfd.alm.service.BondIssuedService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class BondIssuedServiceImpl implements BondIssuedService {

    private final BondIssuedRepository bondIssuedRepository;

    /**
     * Save or update a bond issued.
     *
     * @param bondIssued the bond to save or update.
     * @return the saved or updated bond.
     */
    @Override
    public BondIssued saveOrUpdateBondIssued(BondIssued bondIssued) {
        return bondIssuedRepository.save(bondIssued);
    }

    /**
     * Retrieve all bonds issued.
     *
     * @return a list of all bonds issued.
     */
    @Override
    public List<BondIssued> getAllBondsIssued() {
        return bondIssuedRepository.findAll();
    }

    /**
     * Retrieve a bond issued by its ID.
     *
     * @param id the ID of the bond to retrieve.
     * @return the found bond or null if no bond with the given ID exists.
     */
    @Override
    public BondIssued getBondIssuedById(Long id) {
        return bondIssuedRepository.findById(id).orElse(null);
    }

    /**
     * Delete a bond issued by its ID.
     *
     * @param id the ID of the bond to delete.
     */
    @Override
    public void deleteBondIssuedById(Long id) {
        bondIssuedRepository.deleteById(id);
    }

    /**
     * Logic to calculate the total face value for all bonds issued.
     *
     * @return the total face value.
     */
    @Override
    public BigDecimal getTotalFaceValue() {
        List<BondIssued> bonds = bondIssuedRepository.findAll();
        return bonds.stream()
            .map(BondIssued::getFaceValue)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Logic to determine bonds with a coupon rate above a given threshold.
     *
     * @param rateThreshold the coupon rate threshold.
     * @return a list of bonds with coupon rates above the given threshold.
     */
    @Override
    public List<BondIssued> getHighCouponRateBonds(BigDecimal rateThreshold) {
        return bondIssuedRepository.findAll().stream()
            .filter(bond -> bond.getCouponRate().compareTo(rateThreshold) > 0)
            .collect(Collectors.toList());
    }

    @Override
    public List<BondIssued> getAllBondIssuedsWithinDays(Long first, Long second) {
        LocalDate startDate = LocalDate.now().plusDays(first);
        LocalDate endDate = LocalDate.now().plusDays(second);
        return bondIssuedRepository.findAllByMaturityBetween(startDate, endDate);
    }

}
