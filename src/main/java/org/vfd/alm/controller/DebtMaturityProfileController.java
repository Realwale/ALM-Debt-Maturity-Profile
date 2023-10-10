package org.vfd.alm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vfd.alm.service.DebtMaturityProfileService;

import java.math.BigDecimal;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/debt-maturity")
public class DebtMaturityProfileController {

    private final DebtMaturityProfileService debtMaturityProfileService;

    @GetMapping
    public ResponseEntity<BigDecimal> computeDebtMaturityForBucket(@RequestParam String bucket) {
        try {
            BigDecimal amount = debtMaturityProfileService.computeAndSaveDebtMaturityProfileForBucket(bucket);
            return ResponseEntity.ok(amount);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
