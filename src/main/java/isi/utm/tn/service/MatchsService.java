package isi.utm.tn.service;

import isi.utm.tn.exception.ResourceNotFoundException;
import isi.utm.tn.model.Arbitre;
import isi.utm.tn.model.Matchs;
import isi.utm.tn.repository.ArbitreRepository;
import isi.utm.tn.repository.MatchsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MatchsService {
    @Autowired
    MatchsRepository matchsRepository;

    public List<Matchs> getAllMatchss() {

        return  matchsRepository.findAll();
    }
    public Matchs saveMatchs(Matchs matchs) {

        return matchsRepository.save(matchs);
    }
    public Matchs getMatchs(Long id) {

        return matchsRepository.findById((long) id).orElse(null);
    }
    public String deleteMatchs(long id) {
        matchsRepository.deleteById((long) id);
        return "matchs removed !! " + id;
    }
    public ResponseEntity<Matchs> updateMatchs(
            @PathVariable(value = "id") long id,
            @RequestBody Matchs matchsDetails) throws ResourceNotFoundException {
        Matchs existingMatchs = matchsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Matchs introuvable avec le code = " + id));
        existingMatchs.setTour(matchsDetails.getTour());
        existingMatchs.setResultat(matchsDetails.getResultat());
        existingMatchs.setDateMatch(matchsDetails.getDateMatch());
        existingMatchs.setArbitre(matchsDetails.getArbitre());
        existingMatchs.setEquipe(matchsDetails.getEquipe());
        final Matchs updateMatchs = matchsRepository.save(existingMatchs);
        return ResponseEntity.ok(updateMatchs);
    }
}
