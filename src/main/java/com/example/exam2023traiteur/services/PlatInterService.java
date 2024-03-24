package com.example.exam2023traiteur.services;

import com.example.exam2023traiteur.entities.Plat;

import java.util.List;

public interface PlatInterService {

    void ajouterPlatAffecterClientEtCuisinier(Plat plat, Integer idClient, Integer idCuisinier);
    List<Plat> AfficherListePlatsParClient (String nom, String prenom);
}
