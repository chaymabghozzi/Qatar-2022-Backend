package isi.utm.tn.controller;

import isi.utm.tn.exception.ResourceNotFoundException;
import isi.utm.tn.model.Equipe;
import isi.utm.tn.model.Joueur;
import isi.utm.tn.service.EquipeService;
import isi.utm.tn.service.JoueurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4400")
@RequestMapping("/api/v1")
public class JoueurController {
    @Autowired
    private JoueurService joueurService;

    @PostMapping("/joueur")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public Joueur addJoueur(@RequestBody Joueur joueur) {
        return joueurService.saveJoueur(joueur);
    }

    @GetMapping("/joueur")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public List<Joueur> findAllJoueurs() {
        return joueurService.getAllJoueurs();
    }

    @GetMapping("/joueur/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public Joueur findJoueurById(@PathVariable long id) {
        return joueurService.getJoueur(id);
    }

    @DeleteMapping("/joueur/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public String deleteJoueur(@PathVariable long id) {
        return joueurService.deleteJoueur(id);
    }

    @PutMapping("/joueur")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public void updateJoueur(
            @PathVariable("id") Long id,
            @RequestBody Joueur updateJoueur
    ) throws ResourceNotFoundException {
        joueurService.updateJoueur(id,updateJoueur);
    }
}
