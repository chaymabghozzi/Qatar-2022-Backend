package isi.utm.tn.service;

import isi.utm.tn.exception.ResourceNotFoundException;
import isi.utm.tn.model.Joueur;
import isi.utm.tn.repository.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class JoueurService {

    @Autowired
    JoueurRepository joueurRepository;

    public List<Joueur> getAllJoueurs() {

        return joueurRepository.findAll();
    }

    public Joueur saveJoueur(Joueur joueur) {

        return joueurRepository.save(joueur);
    }

    public Joueur getJoueur(Long id) {

        return joueurRepository.findById((long) id).orElse(null);
    }

    public String deleteJoueur(long id) {
        joueurRepository.deleteById((long) id);
        return "Joueur removed !! " + id;
    }

    public ResponseEntity<Joueur> updateJoueur(
            @PathVariable(value = "id") long id,
            @RequestBody Joueur joueurDetails) throws ResourceNotFoundException {
        Joueur existingJoueur = joueurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("joueur introuvable avec le code = " + id));
        existingJoueur.setNom(joueurDetails.getNom());
        existingJoueur.setPrenom(joueurDetails.getPrenom());
        existingJoueur.setNumero(joueurDetails.getNumero());
        existingJoueur.setAge(joueurDetails.getAge());
        existingJoueur.setFiliere(joueurDetails.getFiliere());
        existingJoueur.setEquipe(joueurDetails.getEquipe());

        final Joueur updatedJoueur = joueurRepository.save(existingJoueur);
        return ResponseEntity.ok(updatedJoueur);

    }
}
