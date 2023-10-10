package org.vfd.alm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "short_term_loan")
public class ShortTermLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bank")
    private String bank;

    @Column(name = "credit_amount")
    private BigDecimal creditAmount;

    @Column(name = "periodic_interest")
    private BigDecimal periodicInterest;

    @Column(name = "interest_rate")
    private BigDecimal interestRate;

    @Column(name = "flat_fees")
    private BigDecimal flatFees;

    @Column(name = "effective_rate")
    private BigDecimal effectiveRate;

    @Column(name = "next_interest_date")
    private LocalDate nextInterestDate;

    @Column(name = "maturity_date")
    private LocalDate maturityDate;

    // Getters, setters, and other boilerplate
}
