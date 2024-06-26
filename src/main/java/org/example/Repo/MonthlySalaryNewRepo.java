package org.example.Repo;

import org.example.Entity.MonthlySalary;
import org.example.Entity.MonthlySalaryNewData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MonthlySalaryNewRepo extends JpaRepository<MonthlySalaryNewData, Long> {
    // List<MonthlySalaryNewData> findAllByVoucherNo(Long voucherNo);
    List<MonthlySalaryNewData> findByEmployeeId(String employeeId);
}
