package org.example.Repo;

import org.example.Entity.NhisReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhisRepo extends JpaRepository<NhisReport, Long> {
    List<NhisReport> findByEmployeeId(String employeeId);
}
