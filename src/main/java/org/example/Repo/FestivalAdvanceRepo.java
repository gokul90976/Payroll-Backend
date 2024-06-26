package org.example.Repo;

import org.example.Entity.FestivalAdvanceReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FestivalAdvanceRepo extends JpaRepository<FestivalAdvanceReport, Long> {
    List<FestivalAdvanceReport> findByEmployeeId(String employeeId);
}
