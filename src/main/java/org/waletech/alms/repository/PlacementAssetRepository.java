package org.waletech.alms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.waletech.alms.entity.PlacementAsset;

import java.time.LocalDate;
import java.util.List;

public interface PlacementAssetRepository extends JpaRepository<PlacementAsset, Long> {
    List<PlacementAsset> findAllByMaturityDateBetween(LocalDate startDate, LocalDate endDate);
}
