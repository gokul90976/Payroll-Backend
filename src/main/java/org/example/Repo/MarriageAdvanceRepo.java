package org.example.Repo;

import org.example.Entity.MarriageAdvanceReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarriageAdvanceRepo extends JpaRepository<MarriageAdvanceReport, Long> {
    List<MarriageAdvanceReport> findByEmployeeId(String employeeId);
}
