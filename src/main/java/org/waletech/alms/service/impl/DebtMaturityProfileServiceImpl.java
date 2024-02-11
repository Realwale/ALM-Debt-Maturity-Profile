package org.waletech.alms.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.waletech.alms.dto.DebtMaturityResponseDTO;
import org.waletech.alms.entity.*;
import org.waletech.alms.repository.DebtMaturityProfileRepository;
import org.waletech.alms.service.*;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DebtMaturityProfileServiceImpl implements DebtMaturityProfileService {


    private final DebtMaturityProfileRepository debtMaturityProfileRepository;

    private final LiabilityReportService liabilityReportService;

    private final OverdraftAccountService overdraftAccountService;

    private final ShortTermLoanService shortTermLoanService;

    private final CommercialPaperService commercialPaperService;

    private final BondIssuedService bondIssuedService;

    private final PlacementAssetService placementAssetService;


    @Transactional
    @Override
    public DebtMaturityResponseDTO computeAndSaveDebtMaturityProfileForBucket(String bucket) {
        debtMaturityProfileRepository.deleteByBucket(bucket);

        BigDecimal totalAmount = BigDecimal.ZERO;
        totalAmount = totalAmount.add(computeForLiabilityReport(bucket));
        totalAmount = totalAmount.add(computeForOverdraftAccount(bucket));
        totalAmount = totalAmount.add(computeForShortTermLoan(bucket));
        totalAmount = totalAmount.add(computeForCommercialPaper(bucket));
        totalAmount = totalAmount.add(computeForBondIssued(bucket));
        totalAmount = totalAmount.add(computeForPlacementAsset(bucket));

        DebtMaturityProfile profile = new DebtMaturityProfile();
        profile.setBucket(bucket);
        profile.setAmount(totalAmount);
        debtMaturityProfileRepository.save(profile);

        return new DebtMaturityResponseDTO(totalAmount);
    }

    private BigDecimal computeForLiabilityReport(String bucket) {
        Pair<Long, Long> daysRange = determineDaysRangeForBucket(bucket);
        List<LiabilityReport> reports = liabilityReportService.getAllLiabilityReportsWithinDays(daysRange.getFirst(), daysRange.getSecond());

        BigDecimal total = BigDecimal.ZERO;
        for (LiabilityReport report : reports) {
            total = total.add(report.getFaceAmount());
        }
        return total;
    }


    private BigDecimal computeForOverdraftAccount(String bucket) {
        Pair<Long, Long> daysRange = determineDaysRangeForBucket(bucket);
        List<OverdraftAccount> accounts = overdraftAccountService.getAllOverdraftAccountsWithinDays(daysRange.getFirst(), daysRange.getSecond());

        BigDecimal total = BigDecimal.ZERO;
        for (OverdraftAccount account : accounts) {
            total = total.add(account.getOutstandingBalance());
        }
        return total;
    }


    private BigDecimal computeForShortTermLoan(String bucket) {
        Pair<Long, Long> daysRange = determineDaysRangeForBucket(bucket);
        List<ShortTermLoan> loans = shortTermLoanService.getAllShortTermLoansWithinDays(daysRange.getFirst(), daysRange.getSecond());

        BigDecimal total = BigDecimal.ZERO;
        for (ShortTermLoan loan : loans) {
            total = total.add(loan.getCreditAmount());
        }
        return total;
    }


    private BigDecimal computeForCommercialPaper(String bucket) {
        Pair<Long, Long> daysRange = determineDaysRangeForBucket(bucket);
        List<CommercialPaper> papers = commercialPaperService.getAllCommercialPapersWithinDays(daysRange.getFirst(), daysRange.getSecond());

        BigDecimal total = BigDecimal.ZERO;
        for (CommercialPaper paper : papers) {
            total = total.add(paper.getAmount());
        }
        return total;
    }

    private BigDecimal computeForBondIssued(String bucket) {
        Pair<Long, Long> daysRange = determineDaysRangeForBucket(bucket);
        List<BondIssued> bonds = bondIssuedService.getAllBondIssuedsWithinDays(daysRange.getFirst(), daysRange.getSecond());

        BigDecimal total = BigDecimal.ZERO;
        for (BondIssued bond : bonds) {
            total = total.add(bond.getFaceValue());
        }
        return total;
    }


    private BigDecimal computeForPlacementAsset(String bucket) {
        Pair<Long, Long> daysRange = determineDaysRangeForBucket(bucket);
        List<PlacementAsset> assets = placementAssetService.getAllPlacementAssetsWithinDays(daysRange.getFirst(), daysRange.getSecond());

        BigDecimal total = BigDecimal.ZERO;
        for (PlacementAsset asset : assets) {
            total = total.add(asset.getFaceAmount());
        }
        return total;
    }


    @Override
    public Pair<Long, Long> determineDaysRangeForBucket(String bucket) {
        if (bucket.matches("\\d+")) {
            long day = Long.parseLong(bucket);
            return Pair.of(day, day);
        }

        else if (bucket.matches("\\d+-\\d+")) {
            String[] parts = bucket.split("-");
            long startDay = Long.parseLong(parts[0].trim());
            long endDay = Long.parseLong(parts[1].split(" ")[0].trim());
            return Pair.of(startDay, endDay);
        }
        else {
            throw new IllegalArgumentException("Invalid bucket format: " + bucket);
        }
    }

}
