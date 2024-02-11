package org.waletech.alms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bond_issued")
public class BondIssued {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bond_name")
    private String bondName;

    @Column(name = "face_value")
    private BigDecimal faceValue;

    @Column(name = "coupon_rate")
    private BigDecimal couponRate;

    @Column(name = "tenor")
    private String tenor;

    @Column(name = "maturity")
    private LocalDate maturity;

    @Column(name = "coupon_value")
    private BigDecimal couponValue;

    @Column(name = "next_coupon_date")
    private LocalDate nextCouponDate;

}
