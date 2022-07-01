package isi.utm.tn.service;

import isi.utm.tn.exception.ResourceNotFoundException;
import isi.utm.tn.model.Equipe;
import isi.utm.tn.model.Joueur;
import isi.utm.tn.repository.EquipeRepository;
import isi.utm.tn.repository.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service

public class EquipeService {
    @Autowired
    EquipeRepository equipeRepository;

    public List<Equipe> getAllEquipes() {

        return equipeRepository.findAll();
    }

    public Equipe saveEquipe(Equipe equipe) {

        return equipeRepository.save(equipe);
    }

    public Equipe getEquipe(Long id) {

        return equipeRepository.findById((long) id).orElse(null);
    }

    public String deleteEquipe(long id) {
        equipeRepository.deleteById((long) id);
        return "Equipe removed !! " + id;
    }

    public ResponseEntity<Equipe> updateEquipe(
            @PathVariable(value = "id") long id,
            @RequestBody Equipe equipeDetails) throws ResourceNotFoundException {
        Equipe existingEquipe = equipeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("equipe introuvable avec le code = " + id));
        existingEquipe.setPays(equipeDetails.getPays());
        existingEquipe.setJoueurs(equipeDetails.getJoueurs());
        existingEquipe.setMatchs(equipeDetails.getMatchs());
        existingEquipe.setNom(equipeDetails.getNom());
        final Equipe updatedEquipe = equipeRepository.save(existingEquipe);
        return ResponseEntity.ok(updatedEquipe);
    }
}
