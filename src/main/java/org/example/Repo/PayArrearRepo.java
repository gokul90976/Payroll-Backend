package org.example.Repo;

import org.example.Entity.PayArrear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayArrearRepo extends JpaRepository<PayArrear, Long> {
    //List<PayArrear> findAllByEmployeeIdIn(List<String> employeeIds);

    List<PayArrear> findByEmployeeId(String employeeId);

    List<PayArrear> findAllByEmployeeIdInAndVoucherNo(List<String> employeeIds, Long voucherNo);

    List<PayArrear> findByVoucherNoIn(List<Long> voucherNosWithDateOfFA);

    List<PayArrear> findByEmployeeIdIn(List<String> employeeIds);
}
