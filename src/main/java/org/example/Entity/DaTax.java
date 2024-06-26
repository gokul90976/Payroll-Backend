package org.example.Entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "da_tax")
public class DaTax {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "N_ID")
    private Long id;

    @Column(name = "PAY_COMMISSION")
    private String payCommission;

    @Column(name = "V_FROM")
    private LocalDate from;

    @Column(name = "V_TO")
    private LocalDate to;

    @Column(name = "DA_PERCENTAGE", length = 20)
    private Long daPercentage;

    private String Date;
}
