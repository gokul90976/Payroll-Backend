package org.example.Repo;

import java.util.List;

import org.example.Entity.MonthlySalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthlySalaryRepo extends JpaRepository<MonthlySalary, Long> {
    // List<MonthlySalary> findAllByVoucherNo(Long voucherNo);

    List<MonthlySalary> findByVoucherNo(Long voucher);

    List<MonthlySalary> findAllByVoucherNo(Long voucherNo);

    List<MonthlySalary> findByVoucherNoIn(List<Long> voucherNos);


    // monthly salary panel filter by login
    //  List<MonthlySalary> findAllByLoggedInBy(String loggedInBy);
}
