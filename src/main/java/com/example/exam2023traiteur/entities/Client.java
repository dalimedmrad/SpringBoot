package com.example.exam2023traiteur.entities;

import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Clients")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;

    @Column
    private String nom;

    @Column
    private String prenom;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    private List<Plat> plats;

    @Column
    @Enumerated(EnumType.STRING)
    private Imcs Imc;


    public enum Imcs {
        FAIBLE,IDEAL,FORT
    }

}
