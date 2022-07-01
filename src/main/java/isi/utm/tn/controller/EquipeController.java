package isi.utm.tn.controller;

import isi.utm.tn.exception.ResourceNotFoundException;
import isi.utm.tn.model.Arbitre;
import isi.utm.tn.model.Equipe;
import isi.utm.tn.service.ArbitreService;
import isi.utm.tn.service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4400")
@RequestMapping("/api/v1")
public class EquipeController {
    @Autowired
    private EquipeService equipeService;

    @PostMapping("/equipe")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public Equipe addEquipe(@RequestBody Equipe equipe) {
        return equipeService.saveEquipe(equipe);
    }

    @GetMapping("/equipe")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public List<Equipe> findAllEquipes() {
        return equipeService.getAllEquipes();
    }

    @GetMapping("/equipe/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public Equipe findEquipeById(@PathVariable long id) {
        return equipeService.getEquipe(id);
    }

    @DeleteMapping("/equipe/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public String deleteEquipe(@PathVariable long id) {
        return equipeService.deleteEquipe(id);
    }

    @PutMapping("/equipe")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public void updateEquipe(
            @PathVariable("id") Long id,
            @RequestBody Equipe updateEquipe
    ) throws ResourceNotFoundException {
        equipeService.updateEquipe(id,updateEquipe);
    }
}
