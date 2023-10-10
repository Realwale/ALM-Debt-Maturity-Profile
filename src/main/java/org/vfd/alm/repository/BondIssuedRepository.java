package org.vfd.alm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vfd.alm.entity.BondIssued;

import java.time.LocalDate;
import java.util.List;

public interface BondIssuedRepository extends JpaRepository<BondIssued, Long> {
    List<BondIssued> findAllByMaturityBetween(LocalDate startDate, LocalDate endDate);
}
