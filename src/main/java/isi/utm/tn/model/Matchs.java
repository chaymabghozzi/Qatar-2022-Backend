package isi.utm.tn.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data

@Entity
@Table(name="matchs")
public class Matchs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private Long id;

    private String tour;
    private String resultat;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMatch;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    Set<Arbitre> arbitre = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    Set<Equipe> equipe = new HashSet<>();

    public Matchs() {
        super();
        // TODO Auto-generated constructor stub
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTour() {
        return tour;
    }

    public void setTour(String tour) {
        this.tour = tour;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public Date getDateMatch() {
        return dateMatch;
    }

    public void setDateMatch(Date dateMatch) {
        this.dateMatch = dateMatch;
    }

    public Set<Arbitre> getArbitre() {
        return arbitre;
    }

    public void setArbitre(Set<Arbitre> arbitre) {
        this.arbitre = arbitre;
    }

    public Set<Equipe> getEquipe() {
        return equipe;
    }

    public void setEquipe(Set<Equipe> equipe) {
        this.equipe = equipe;
    }

    public Matchs(String tour, String resultat, Date dateMatch, Set<Arbitre> arbitre, Set<Equipe> equipe) {
        super();
        this.tour = tour;
        this.resultat = resultat;
        this.dateMatch = dateMatch;
        this.arbitre = arbitre;
        this.equipe = equipe;
    }
}