package org.example.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Setter
@Getter
@Table(name = "percentage")
public class Percentage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERCENTAGE_ID")
    private Long percentageId;
    @Column(name = "HRR_PERCENTAGE")
    private Long hrrPercentage;
    @Column(name = "GPF_PERCENTAGE")
    private Long gpfPercentage;
    @Column(name = "CPS_PERCENTAGE")
    private Long cpsPercentage;
    @Column(name = "HBF_PERCENTAGE")
    private Long hbfPercentage;
    @Column(name = "ITC_PERCENTAGE")
    private Long itcPercentage;


}
