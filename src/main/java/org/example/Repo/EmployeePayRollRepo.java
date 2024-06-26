package org.example.Repo;

import org.example.Entity.EmployeePayRoll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Repository
public interface EmployeePayRollRepo extends JpaRepository<EmployeePayRoll, Long> {
    EmployeePayRoll findByEmployeeId(String empId);


//    @Query(value="SELECT" +
//            "    e.v_employee_name AS empName, e.d_date_of_birth AS DOB, a.d_date_of_joining_service AS DOJ, e.n_aadhaar_number AS Aadhaar, e.v_pan_number AS PAN," +
//            "    e.v_office_code AS officeCode, e.v_office_name AS officeName, e.v_cadre_code AS cadreCode, e.v_cadre_name AS cadreName, c.v_basic_pay AS basicPay, c.v_scale_of_pay AS scale," +
//            "    c.v_level_as_per_pay_matrix AS level, c.v_cell_as_per_pay_matrix AS cell, e.v_differently_abled AS disability " +
//            "FROM tnestablishment.employee_personalinfo e " +
//            "JOIN tnestablishment.appointment_info a ON e.n_id = a.m_id " +
//            "JOIN tnestablishment.current_pay_info c ON e.n_id = c.m_id " +
//            "WHERE e.v_employee_id = :empId ", nativeQuery = true)
//    List<Map<String, Object>> findEmpDetails(@RequestParam("empId") String empId);
}
