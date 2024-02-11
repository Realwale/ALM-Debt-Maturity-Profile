package org.waletech.alms.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.waletech.alms.entity.PlacementAsset;
import org.waletech.alms.service.PlacementAssetService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/placement-assets")
public class PlacementAssetController {

    private final PlacementAssetService placementAssetService;

    @GetMapping
    public ResponseEntity<List<PlacementAsset>> getAllPlacementAssets() {
        return new ResponseEntity<>(placementAssetService.getAllPlacementAssets(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<PlacementAsset> createPlacementAsset(@RequestBody PlacementAsset placementAsset){
        return new ResponseEntity<>(placementAssetService.saveOrUpdatePlacementAsset(placementAsset), HttpStatus.CREATED);
    }


}
