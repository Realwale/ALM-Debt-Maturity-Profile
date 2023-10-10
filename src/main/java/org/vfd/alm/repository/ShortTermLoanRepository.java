package org.vfd.alm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vfd.alm.entity.ShortTermLoan;

import java.time.LocalDate;
import java.util.List;

public interface ShortTermLoanRepository extends JpaRepository<ShortTermLoan, Long> {
    List<ShortTermLoan> findAllByNextInterestDateBetween(LocalDate startDate, LocalDate endDate);
}
