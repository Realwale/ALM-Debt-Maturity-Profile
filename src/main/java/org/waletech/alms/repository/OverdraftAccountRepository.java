package org.waletech.alms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.waletech.alms.entity.OverdraftAccount;

import java.time.LocalDate;
import java.util.List;

public interface OverdraftAccountRepository extends JpaRepository<OverdraftAccount, Long> {
    List<OverdraftAccount> findAllByRecyclingDateBetween(LocalDate startDate, LocalDate endDate);
}
