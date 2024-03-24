package com.example.exam2023traiteur.services;

import com.example.exam2023traiteur.entities.Client;
import com.example.exam2023traiteur.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;


@Service
@Slf4j
@AllArgsConstructor
public class ClientService implements ClientInterService{

    private ClientRepository clientrepository;

    @Override
    public Client ajouterClient(Client client) {
        Client ct = new Client();
        ct.setNom(client.getNom());
        ct.setPrenom(client.getPrenom());
        ct.setImc(client.getImc());
        return clientrepository.save(ct);
    }
}
