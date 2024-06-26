package org.example.Repo;

import org.example.Entity.ConvenyanceAdvanceReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConvenyanceAdvanceRepo extends JpaRepository<ConvenyanceAdvanceReport, Long> {
    List<ConvenyanceAdvanceReport> findByEmployeeId(String employeeId);
}