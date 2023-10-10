package org.vfd.alm.service;

import org.vfd.alm.entity.PlacementAsset;

import java.math.BigDecimal;
import java.util.List;

public interface PlacementAssetService {
    PlacementAsset saveOrUpdatePlacementAsset(PlacementAsset placementAsset);

    List<PlacementAsset> getAllPlacementAssets();

    PlacementAsset getPlacementAssetById(Long id);

    void deletePlacementAssetById(Long id);

    BigDecimal getTotalFaceAmount();

    List<PlacementAsset> getHighRatePlacementAssets(BigDecimal rateThreshold);

    List<PlacementAsset> getAllPlacementAssetsWithinDays(Long first, Long second);
}
