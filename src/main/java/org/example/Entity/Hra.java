package org.example.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "HRA")
@Data
public class Hra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HRA_ID")
    private Long hraId;

    @Column(name = "PAYRANGE_FROM")
    private Long payRangeFrom;

    @Column(name = "PAYRANGE_TO")
    private Long payRangeTo;

    @Column(name = "GRANDE_1")
    private Long grade01;

    @Column(name = "GRADE_2")
    private Long grade02;

    @Column(name = "GRADE_3")
    private Long grade03;

    @Column(name = "GRADE_4")
    private Long grade04;

    @Column(name = "GRADE_5")
    private Long grade05;


}
