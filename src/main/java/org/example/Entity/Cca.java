package org.example.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "CCA")
@Data
public class Cca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CCA_ID")
    private Long ccaId;

    @Column(name = "CCAFROM_PAY")
    private Long ccaFromPay;

    @Column(name = "CCATO_PAY")
    private Long ccaToPay;

    @Column(name = "CCA_FIRST_VALUE")
    private Long ccaFirstValue;

    @Column(name = "CCA_SECOND_VALUE")
    private Long ccaSecondValue;


}
