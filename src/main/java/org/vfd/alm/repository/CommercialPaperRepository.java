package org.vfd.alm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vfd.alm.entity.CommercialPaper;

import java.time.LocalDate;
import java.util.List;

public interface CommercialPaperRepository extends JpaRepository<CommercialPaper, Long> {
    List<CommercialPaper> findAllByMaturityDateBetween(LocalDate startDate, LocalDate endDate);
}
