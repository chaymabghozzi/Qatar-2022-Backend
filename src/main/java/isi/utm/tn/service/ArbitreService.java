package isi.utm.tn.service;

import isi.utm.tn.exception.ResourceNotFoundException;
import isi.utm.tn.model.Arbitre;
import isi.utm.tn.repository.ArbitreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ArbitreService {

    @Autowired
    ArbitreRepository arbitreRepository;

    public List<Arbitre> getAllArbitres() {

        return  arbitreRepository.findAll();
    }
    public Arbitre saveArbitre(Arbitre arbitre) {

        return arbitreRepository.save(arbitre);
    }
    public Arbitre getArbitre(Long id) {

        return arbitreRepository.findById((long) id).orElse(null);
    }
    public String deleteArbitre(long id) {
        arbitreRepository.deleteById((long) id);
        return "Arbitre removed !! " + id;
    }
    public ResponseEntity<Arbitre> updateArbitre(
            Long id, @RequestBody Arbitre arbitreDetails) throws ResourceNotFoundException {
        Arbitre existingArbitre = arbitreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Arbitre introuvable avec le code = " + id));
        existingArbitre.setNom(arbitreDetails.getNom());
        existingArbitre.setPrenom(arbitreDetails.getPrenom());
        existingArbitre.setFiliere(arbitreDetails.getFiliere());
        existingArbitre.setMatchs(arbitreDetails.getMatchs());
        final Arbitre updateArbitre = arbitreRepository.save(existingArbitre);
        return ResponseEntity.ok(updateArbitre);
    }
}
