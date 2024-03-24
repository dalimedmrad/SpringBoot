package com.example.exam2023traiteur.controllers;


import com.example.exam2023traiteur.entities.Client;
import com.example.exam2023traiteur.services.ClientInterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientRestController {

    ClientInterService clientservice;

    @PostMapping("/add")
    @ResponseBody
    public Client ajouterClient(@RequestBody Client client) {

        return clientservice.ajouterClient(client);
    }
}
