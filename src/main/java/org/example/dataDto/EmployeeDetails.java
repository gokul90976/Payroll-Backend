package org.example.dataDto;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class EmployeeDetails {

    private String employeeId;
    private String employeeName;
    private String designationName;
    private String designationCode;
    private String pfcps;
    private Map<String, Long> monthWiseDiff = new HashMap<>();

    private Map<String, Long> monthWiseSalary = new HashMap<>();
    private List<String> columnDefinitions;


    // Getters and setters

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Map<String, Long> getMonthWiseSalary() {
        return monthWiseSalary;
    }


    public void setMonthWiseSalary(String month, Long basicAndPersonal) {
        this.monthWiseSalary.put(month, basicAndPersonal);

    }

    public void setMonthWiseDiff(String month, Long amount) {
        this.monthWiseDiff.put(month + "Diff", amount);
    }
}