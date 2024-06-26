package org.example.dataDto;

import lombok.Data;

@Data

public class DaEmployeeDto {


    private String employeeId;
    private String employeeName;
    private String officeName;
    private String designationCode;
    private String pfcps;
    private double netPay;
    private double totalEarning;
    private double totalDeductions;
}
