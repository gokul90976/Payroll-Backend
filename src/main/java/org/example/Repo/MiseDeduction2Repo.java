package org.example.Repo;

import org.example.Entity.MiscDeductionReport2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MiseDeduction2Repo extends JpaRepository<MiscDeductionReport2, Long> {
    List<MiscDeductionReport2> findByEmployeeId(String employeeId);
}
