package org.example.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "recovery_data")
public class RecoveryData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recovery_id")
    private Long recoveryId;

    @Column(name = "V_EMPLOYEE_ID", length = 25)
    private String employeeId;
    @Column(name = "V_EMPLOYEE_NAME", length = 100)
    private String employeeName;


    @JsonManagedReference
    @OneToMany(mappedBy = "recoveryData", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecoveryDataAdd> recoveryDataAdd;


}