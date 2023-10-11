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
@Table(name = "overdraft_account")
public class OverdraftAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bank")
    private String bank;

    @Column(name = "outstanding_balance")
    private BigDecimal outstandingBalance;

    @Column(name = "global_balance")
    private BigDecimal globalBalance;

    @Column(name = "interest_rate")
    private BigDecimal interestRate;

    @Column(name = "flat_fees")
    private BigDecimal flatFees;

    @Column(name = "monthly_interest")
    private BigDecimal monthlyInterest;

    @Column(name = "next_interest_payment")
    private LocalDate nextInterestPayment;

    @Column(name = "recycling_date")
    private LocalDate recyclingDate;

}
