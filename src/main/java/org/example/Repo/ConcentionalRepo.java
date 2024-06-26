package org.example.Repo;


import org.example.Entity.Concessional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcentionalRepo extends JpaRepository<Concessional, Long> {
}
