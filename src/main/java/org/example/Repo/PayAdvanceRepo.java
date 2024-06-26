package org.example.Repo;

import org.example.Entity.PayAdvanceReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayAdvanceRepo extends JpaRepository<PayAdvanceReport, Long> {
    List<PayAdvanceReport> findByEmployeeId(String employeeId);
}