package org.vfd.alm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "commercial_paper")
public class CommercialPaper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "series")
    private String series;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "discount_rate")
    private BigDecimal discountRate;

    @Column(name = "discount_value")
    private BigDecimal discountValue;

    @Column(name = "initial_tenor")
    private int initialTenor;

    @Column(name = "offer_date")
    private LocalDate offerDate;

    @Column(name = "maturity_date")
    private LocalDate maturityDate;

    // Getters, setters, and other boilerplate
}
