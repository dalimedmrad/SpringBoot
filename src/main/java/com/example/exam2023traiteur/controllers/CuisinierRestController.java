package com.example.exam2023traiteur.controllers;


import com.example.exam2023traiteur.entities.Cuisinier;
import com.example.exam2023traiteur.services.CuisisnerInterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/cuisisner")
public class CuisinierRestController {


    CuisisnerInterService cuisinerservice;


    @PostMapping("/add")
    @ResponseBody
    public void ajouterCuisinier(@RequestBody Cuisinier cuisinier) {
        cuisinerservice.ajouterCuisinier(cuisinier);

    }
}
