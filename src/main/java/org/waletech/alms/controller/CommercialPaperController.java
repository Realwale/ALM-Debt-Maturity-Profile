package org.waletech.alms.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.waletech.alms.entity.CommercialPaper;
import org.waletech.alms.service.CommercialPaperService;

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
