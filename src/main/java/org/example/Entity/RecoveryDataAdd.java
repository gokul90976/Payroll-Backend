package org.example.Entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Data
@Getter
@Setter
@Table(name = "recovery_data_add")
public class RecoveryDataAdd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recovery_data_id")
    private Long recoverydataId;

    @Column(name = "V_RECOVERY", length = 25)
    private String recovery;


    @Column(name = "V_Recoverd", length = 25)
    private BigDecimal recoverd = BigDecimal.ZERO;

//    @Column(name = "V_Recoverd_Total", length = 25)
//    private BigDecimal recoverdTotal = BigDecimal.ZERO;

    @Column(name = "N_TOTAL_DEMAND", length = 50)
    private Long totalDemand;

    @Column(name = "N_PER_MONTH_DEMAND", length = 20)
    private Long perMonthDemand;

    @Column(name = "N_REGULAR_MONTH_DEMAND", length = 20)
    private Long regularMonthDemand;

    @Column(name = "N_LAST_MONTH_DEMAND", length = 20)
    private Long lastMonthDemand;
    @Column(name = "COUNT")
    private Long count = 0L;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "D_DATE")
    private LocalDate date;

    @Column(name = "N_NO_OF_MONTHS", length = 20)
    private Long noOfMonths;

    @Column(name = "N_BALANCE_AMOUNT", length = 20)
    private BigDecimal balanceAmount;

    @Column(name = "V_LASTMONTH_BALANCEAMOUNT", length = 25)
    private String LastmonthBalanceAmount;

    @JsonBackReference
    @ManyToOne

    @JoinColumn(name = "recovery_id")
    private RecoveryData recoveryData;

}
