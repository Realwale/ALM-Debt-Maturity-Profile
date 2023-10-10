package org.vfd.alm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vfd.alm.entity.ShortTermLoan;
import org.vfd.alm.service.ShortTermLoanService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/short-term-loans")
public class ShortTermLoanController {

    private final ShortTermLoanService shortTermLoanService;

    @GetMapping
    public ResponseEntity<List<ShortTermLoan>> getAllShortTermLoans() {
        return new ResponseEntity<>(shortTermLoanService.getAllShortTermLoans(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ShortTermLoan> createShortTermLoan(@RequestBody ShortTermLoan shortTermLoan){
        return new ResponseEntity<>(shortTermLoanService.saveOrUpdateShortTermLoan(shortTermLoan), HttpStatus.CREATED);
    }

}
