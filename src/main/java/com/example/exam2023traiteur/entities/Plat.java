package com.example.exam2023traiteur.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.OffsetDateTime;
import java.util.Set;

@Entity
@Table(name = "Plats")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Plat {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlat;

    @Column
    private String label;

    @Column
    private Double prix;

    @Column
    private Double calories;

    @ManyToMany(mappedBy = "plats",cascade = CascadeType.ALL)
    private Set<Cuisinier> cuisiniers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @Column
    @Enumerated(EnumType.STRING)
    private Categories Categorie;

    public Plat(String label, String categorie, Double prix, Double calories) {
    }


    public enum Categories {
        ENTREE,PRINCIPAL,DESSERT
    }

}
