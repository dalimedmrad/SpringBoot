package com.example.exam2023traiteur.services;

import com.example.exam2023traiteur.entities.Cuisinier;
import com.example.exam2023traiteur.repositories.CuisinierRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@AllArgsConstructor
public class CuisinierService implements CuisisnerInterService{

    CuisinierRepository  cuisinierrepository;
    @Override
    public void ajouterCuisinier(Cuisinier cuisinier) {
        cuisinierrepository.save(cuisinier);
        System.out.println("Cuisiner added with successfully");

    }
}
