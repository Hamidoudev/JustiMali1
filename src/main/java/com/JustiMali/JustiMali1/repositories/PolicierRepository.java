package com.JustiMali.JustiMali1.repositories;

import com.JustiMali.JustiMali1.models.Policier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicierRepository extends JpaRepository<Policier, Long> {
}
