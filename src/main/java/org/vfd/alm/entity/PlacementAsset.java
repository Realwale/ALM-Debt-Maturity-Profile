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
@Setter
@Getter
@Entity
@Table(name = "placement_assets")
public class PlacementAsset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "counterparty")
    private String counterparty;

    @Column(name = "date_opened")
    private LocalDate dateOpened;

    @Column(name = "maturity_date")
    private LocalDate maturityDate;

    @Column(name = "face_amount")
    private BigDecimal faceAmount;

    @Column(name = "rate")
    private BigDecimal rate;

    // Getters, setters, and other boilerplate
}
