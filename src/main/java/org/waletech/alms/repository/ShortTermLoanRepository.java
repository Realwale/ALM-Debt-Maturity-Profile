package org.waletech.alms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.waletech.alms.entity.ShortTermLoan;

import java.time.LocalDate;
import java.util.List;

public interface ShortTermLoanRepository extends JpaRepository<ShortTermLoan, Long> {
    List<ShortTermLoan> findAllByNextInterestDateBetween(LocalDate startDate, LocalDate endDate);
}
