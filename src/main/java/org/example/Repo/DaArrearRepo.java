package org.example.Repo;

import org.example.Entity.DaArrear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DaArrearRepo extends JpaRepository<DaArrear, Long> {
    //  List<DaArrear> findAllByEmployeeIdIn(List<String> employeeIds);

    List<DaArrear> findByEmployeeId(String employeeId);

    List<DaArrear> findAllByEmployeeIdInAndVoucherNo(List<String> employeeIds, Long voucherNo);
}
