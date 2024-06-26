package org.example.Repo;

import org.example.Entity.CpsReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CpsRepo extends JpaRepository<CpsReport, Long> {
    List<CpsReport> findByEmployeeId(String employeeId);
}
