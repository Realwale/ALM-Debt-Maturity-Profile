package org.vfd.alm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vfd.alm.entity.LiabilityReport;
import org.vfd.alm.service.LiabilityReportService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/liability-reports")
public class LiabilityReportController {

    private final LiabilityReportService liabilityReportService;

    @GetMapping
    public ResponseEntity<List<LiabilityReport>> getAllLiabilityReports() {
        return new ResponseEntity<>(liabilityReportService.getAllLiabilityReports(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LiabilityReport> getLiabilityReportById(@PathVariable Long id) {
        LiabilityReport report = liabilityReportService.getLiabilityReportById(id);
        if(report != null) {
            return new ResponseEntity<>(report, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<LiabilityReport> createLiabilityReport(@RequestBody LiabilityReport liabilityReport) {
        return new ResponseEntity<>(liabilityReportService.saveOrUpdateLiabilityReport(liabilityReport), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LiabilityReport> updateLiabilityReport(@PathVariable Long id, @RequestBody LiabilityReport liabilityReport) {
        // This could include additional logic such as checking if the report exists before updating
        return new ResponseEntity<>(liabilityReportService.saveOrUpdateLiabilityReport(liabilityReport), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLiabilityReport(@PathVariable Long id) {
        liabilityReportService.deleteLiabilityReportById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
