package org.example.dataDto;

import lombok.Data;

@Data

public class EmployeeDataDto {

    private String employeeId;
    private String employeeName;
    private String officeName;
    private String designationCode;
    private double netPay;
    private double totalDifferenceOfArrear;
    private double totalEarning;
    private double totalDeductions;
}
