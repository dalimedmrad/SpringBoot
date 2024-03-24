package com.example.exam2023traiteur.services;


import com.example.exam2023traiteur.entities.Client;
import com.example.exam2023traiteur.entities.Cuisinier;
import com.example.exam2023traiteur.entities.Plat;
import com.example.exam2023traiteur.repositories.ClientRepository;
import com.example.exam2023traiteur.repositories.CuisinierRepository;
import com.example.exam2023traiteur.repositories.PlatRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class PlatService implements PlatInterService{

    ClientRepository clientRepository;
    CuisinierRepository cuisinierRepository;
    PlatRepository platRepository;
    @Override
    public void ajouterPlatAffecterClientEtCuisinier(Plat plat, Integer idClient, Integer idCuisinier) {
        // Vérifier que les identifiants client et cuisinier ne sont pas nuls
        if (idClient == null || idCuisinier == null) {
            throw new IllegalArgumentException("Les identifiants du client et du cuisinier doivent être fournis");
        }

        // Trouver le client et le cuisinier en fonction de leurs identifiants
        Client client = clientRepository.findById(idClient)
                .orElseThrow(() -> new IllegalArgumentException("Client non trouvé avec l'ID : " + idClient));
        Cuisinier cuisinier = cuisinierRepository.findById(idCuisinier)
                .orElseThrow(() -> new IllegalArgumentException("Cuisinier non trouvé avec l'ID : " + idCuisinier));

        // Créer une instance de Plat avec les informations fournies
        //Plat plat = new Plat(label, categorie, prix, calories);

        // Vérifier si le plat est un plat principal et si le client a déjà commandé deux plats principaux
        if (plat.getCategorie().equals("PRINCIPAL")) {
            long countMainDishes = client.getPlats().stream()
                    .filter(p -> "PRINCIPAL".equals(p.getCategorie()))
                    .count();
            if (countMainDishes >= 2) {
                throw new RuntimeException("Le client ne peut pas commander plus de deux plats principaux");
            }
        }

        // Associer le plat au client et au cuisinier
        plat.setClient(client);
        Set<Cuisinier> cuisiniers = new HashSet<>();
        cuisiniers.add(cuisinier);
        plat.setCuisiniers(cuisiniers);

        // Enregistrer le plat
        platRepository.save(plat);
    }

    @Override
    public List<Plat> AfficherListePlatsParClient(String nom, String prenom) {
        // Trouver le client par son nom et prénom
        Client client = clientRepository.findByNomAndPrenom(nom, prenom);

        // Vérifier si le client existe
        if (client == null) {
            throw new RuntimeException("Client not found");
        }

        // Récupérer la liste des plats du client
        List<Plat> plats = client.getPlats();

        // Afficher la liste des plats
        for (Plat plat : plats) {
            System.out.println(plat.getLabel());
        }

        return plats;
    }



}
