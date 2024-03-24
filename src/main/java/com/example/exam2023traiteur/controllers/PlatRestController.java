package com.example.exam2023traiteur.controllers;

import com.example.exam2023traiteur.entities.Client;
import com.example.exam2023traiteur.entities.Plat;
import com.example.exam2023traiteur.services.PlatInterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/plat")
public class PlatRestController {

    PlatInterService platservice;

    @PostMapping("/add/{idClient}/{idCuisinier}")
    @ResponseBody
    public void ajouterPlatAffecterClientEtCuisinier(@RequestBody Plat plat, @PathVariable Integer idClient, @PathVariable Integer idCuisinier) {
        platservice.ajouterPlatAffecterClientEtCuisinier(plat, idClient, idCuisinier);
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Plat> AfficherListePlatsParClient(@RequestBody Client client) {
      return   platservice.AfficherListePlatsParClient(client.getNom(),client.getPrenom());
    }

}
