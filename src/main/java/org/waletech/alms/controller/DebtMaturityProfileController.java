package org.waletech.alms.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.waletech.alms.dto.DebtMaturityResponseDTO;
import org.waletech.alms.service.DebtMaturityProfileService;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/compute/debt-maturity")
public class DebtMaturityProfileController {

    private final DebtMaturityProfileService debtMaturityProfileService;

    @GetMapping
    public ResponseEntity<DebtMaturityResponseDTO> computeDebtMaturity(
            @RequestParam(required = false) Long days,
            @RequestParam(required = false) Long fromDay,
            @RequestParam(required = false) Long toDay) {

        String bucket;

        if (days != null) {
            bucket = days.toString();
        } else if (fromDay != null && toDay != null) {
            bucket = fromDay + "-" + toDay;
        } else {
            return ResponseEntity.badRequest().body(null);
        }

        DebtMaturityResponseDTO response = debtMaturityProfileService.computeAndSaveDebtMaturityProfileForBucket(bucket);
        return ResponseEntity.ok(response);
    }

}
