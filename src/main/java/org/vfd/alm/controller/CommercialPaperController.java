package org.vfd.alm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vfd.alm.entity.CommercialPaper;
import org.vfd.alm.service.CommercialPaperService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/commercial-papers")
public class CommercialPaperController {

    private final CommercialPaperService commercialPaperService;

    @GetMapping
    public ResponseEntity<List<CommercialPaper>> getAllCommercialPapers() {
        return new ResponseEntity<>(commercialPaperService.getAllCommercialPapers(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<CommercialPaper> createCommercialPapers(@RequestBody CommercialPaper commercialPaper){
        return new ResponseEntity<>(commercialPaperService.saveOrUpdateCommercialPaper(commercialPaper), HttpStatus.CREATED);
    }
}
