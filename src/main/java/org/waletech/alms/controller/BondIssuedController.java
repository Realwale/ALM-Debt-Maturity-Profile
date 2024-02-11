package org.waletech.alms.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.waletech.alms.entity.BondIssued;
import org.waletech.alms.service.BondIssuedService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/bonds-issued")
public class BondIssuedController {

    private final BondIssuedService bondIssuedService;

    @GetMapping
    public ResponseEntity<List<BondIssued>> getAllBondsIssued() {
        return new ResponseEntity<>(bondIssuedService.getAllBondsIssued(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<BondIssued> createBondIssued(@RequestBody BondIssued bondIssued){
        return new ResponseEntity<>(bondIssuedService.saveOrUpdateBondIssued(bondIssued), HttpStatus.CREATED);
    }


}
