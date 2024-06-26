package org.example.Repo;

import org.example.Entity.TemporaryEmployeePayroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemporaryEmployeeRepo extends JpaRepository<TemporaryEmployeePayroll, Long> {
}
