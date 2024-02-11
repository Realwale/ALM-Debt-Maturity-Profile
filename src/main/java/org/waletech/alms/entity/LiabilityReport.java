package org.waletech.alms.entity;

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
@Table(name = "liability_report")
public class LiabilityReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "effective_date")
    private LocalDate effectiveDate;

    @Column(name = "settlement_date")
    private LocalDate settlementDate;

    @Column(name = "face_amount")
    private BigDecimal faceAmount;

    @Column(name = "rate")
    private BigDecimal rate;

    @Column(name = "ttm")
    private BigDecimal ttm;
}
