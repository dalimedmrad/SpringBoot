package com.example.exam2023traiteur.repositories;


import com.example.exam2023traiteur.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {

    Client findByNomAndPrenom(String nom, String prenom);

}
