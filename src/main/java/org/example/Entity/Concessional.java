package org.example.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Concessional")
@Data

public class Concessional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Concessional")
    private Long ConcessionalId;

    @Column(name = "PAYRANGE_FROM")
    private Double payRangeFrom;

    @Column(name = "PAYRANGE_TO")
    private Double payRangeTo;

    @Column(name = "GRANDE_1")
    private Double grade01;

    @Column(name = "GRADE_2")
    private Double grade02;

    @Column(name = "GRADE_3")
    private Double grade03;

    @Column(name = "GRADE_4")
    private Double grade04;
}