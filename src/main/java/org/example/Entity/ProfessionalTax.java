package org.example.Entity;

import lombok.Data;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Data
@Table(name = "professional_Tax")
public class ProfessionalTax {

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

}
