package org.example.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "income_Tax")
public class IncomeTax {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "N_ID")
    private Long id;

    @Column(name = "N_FROM", length = 20)
    private Long from;

    @Column(name = "N_TO", length = 20)
    private Long to;

    @Column(name = "N_VALUES", length = 20)
    private Long values;

    private String Date;
}
