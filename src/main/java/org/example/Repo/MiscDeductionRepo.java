package org.example.Repo;

import org.example.Entity.MiscDeductionReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MiscDeductionRepo extends JpaRepository<MiscDeductionReport, Long> {
    List<MiscDeductionReport> findByEmployeeId(String employeeId);
}