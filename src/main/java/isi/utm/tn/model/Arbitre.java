package isi.utm.tn.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
public class Arbitre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String filiere;

    @ManyToOne
    @JoinColumn(name = "matchs_id")
    private Matchs matchs;

    public Arbitre() {
        super();
        // TODO Auto-generated constructor stub
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public Matchs getMatchs() {
        return matchs;
    }

    public void setMatchs(Matchs matchs) {
        this.matchs = matchs;
    }

    public Arbitre(String nom, String prenom, String filiere, Matchs matchs) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.filiere = filiere;
        this.matchs = matchs;
    }


}
