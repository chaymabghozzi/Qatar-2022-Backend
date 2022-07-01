package isi.utm.tn.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Data

@Entity
@Table(name="equipe")
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String nom;
    private String pays;

    @OneToMany(mappedBy = "equipe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    Set<Joueur> joueurs = new HashSet<>();

    @ManyToMany(mappedBy = "equipe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    Set<Matchs> matchs = new HashSet<>();

    public Equipe() {

    }

    public Equipe(String nom, String pays, Set<Joueur> joueurs, Set<Matchs> matchs) {
        this.id=id;
        this.nom = nom;
        this.pays = pays;
        this.joueurs = joueurs;
        this.matchs = matchs;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Set<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(Set<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public Set<Matchs> getMatchs() {
        return matchs;
    }

    public void setMatchs(Set<Matchs> matchs) {
        this.matchs = matchs;
    }
}
