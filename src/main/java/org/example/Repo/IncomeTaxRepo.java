package org.example.Repo;

import org.example.Entity.IncomeTax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeTaxRepo extends JpaRepository<IncomeTax, Long> {

}
