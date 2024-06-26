package org.example.dataDto;

import lombok.Data;
import org.example.Entity.EmployeePayRoll;
import org.example.Entity.PersonalData;

@Data
public class EmployeeDataResponse {

    private PersonalData personalData;
    private EmployeePayRoll employeePayRoll;

    public EmployeeDataResponse(PersonalData personalData, EmployeePayRoll employeePayRoll) {
        this.personalData = personalData;
        this.employeePayRoll = employeePayRoll;
    }

}
