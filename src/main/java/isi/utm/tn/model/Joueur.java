package isi.utm.tn.model;

import lombok.Data;


import javax.persistence.*;
@Data
@Entity
@Table(name="joueur")
public class Joueur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String prenom;
    private String nom;
    private int numero;
    private int age;
    private String filiere;

    @ManyToOne(cascade=CascadeType.ALL)
    private Equipe equipe;

    public Joueur() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Joueur(String prenom, String nom, int numero, int age, String filiere, Equipe equipe)
    {
        super();
        this.prenom = prenom;
        this.nom = nom;
        this.numero = numero;
        this.age = age;
        this.filiere = filiere;
        this.equipe = equipe;
    }


}
