package org.example.Repo;

import org.example.Entity.Hra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HraRepo extends JpaRepository<Hra, Long> {
}
