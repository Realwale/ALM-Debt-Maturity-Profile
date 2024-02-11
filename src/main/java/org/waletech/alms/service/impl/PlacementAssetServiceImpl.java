package org.waletech.alms.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.waletech.alms.entity.PlacementAsset;
import org.waletech.alms.repository.PlacementAssetRepository;
import org.waletech.alms.service.PlacementAssetService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PlacementAssetServiceImpl implements PlacementAssetService {

    private final PlacementAssetRepository placementAssetRepository;

    /**
     * Save or update a placement asset.
     *
     * @param placementAsset the asset to save or update.
     * @return the saved or updated asset.
     */
    @Override
    public PlacementAsset saveOrUpdatePlacementAsset(PlacementAsset placementAsset) {
        return placementAssetRepository.save(placementAsset);
    }

    /**
     * Retrieve all placement assets.
     *
     * @return a list of all placement assets.
     */
    @Override
    public List<PlacementAsset> getAllPlacementAssets() {
        return placementAssetRepository.findAll();
    }

    /**
     * Retrieve a placement asset by its ID.
     *
     * @param id the ID of the asset to retrieve.
     * @return the found asset or null if no asset with the given ID exists.
     */
    @Override
    public PlacementAsset getPlacementAssetById(Long id) {
        return placementAssetRepository.findById(id).orElse(null);
    }

    /**
     * Delete a placement asset by its ID.
     *
     * @param id the ID of the asset to delete.
     */
    @Override
    public void deletePlacementAssetById(Long id) {
        placementAssetRepository.deleteById(id);
    }

    /**
     * Logic to calculate the total face amount for all placement assets.
     *
     * @return the total face amount.
     */
    @Override
    public BigDecimal getTotalFaceAmount() {
        List<PlacementAsset> assets = placementAssetRepository.findAll();
        return assets.stream()
            .map(PlacementAsset::getFaceAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Logic to determine placement assets with a rate above a given threshold.
     *
     * @param rateThreshold the rate threshold.
     * @return a list of placement assets with rates above the given threshold.
     */
    @Override
    public List<PlacementAsset> getHighRatePlacementAssets(BigDecimal rateThreshold) {
        return placementAssetRepository.findAll().stream()
            .filter(asset -> asset.getRate().compareTo(rateThreshold) > 0)
            .collect(Collectors.toList());
    }

    @Override
    public List<PlacementAsset> getAllPlacementAssetsWithinDays(Long first, Long second) {
        LocalDate startDate = LocalDate.now().plusDays(first);
        LocalDate endDate = LocalDate.now().plusDays(second);
        return placementAssetRepository.findAllByMaturityDateBetween(startDate, endDate);
    }

}
