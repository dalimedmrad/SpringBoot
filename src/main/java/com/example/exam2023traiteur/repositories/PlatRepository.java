package com.example.exam2023traiteur.repositories;

import com.example.exam2023traiteur.entities.Plat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatRepository extends JpaRepository<Plat,Integer> {
}
