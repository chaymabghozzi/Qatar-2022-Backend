package isi.utm.tn.controller;

import isi.utm.tn.exception.ResourceNotFoundException;
import isi.utm.tn.model.Equipe;
import isi.utm.tn.model.Matchs;
import isi.utm.tn.service.EquipeService;
import isi.utm.tn.service.MatchsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4400")
@RequestMapping("/api/v1")
public class MatchsController {

    @Autowired
    private MatchsService matchsService;

    @PostMapping("/matchs")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public Matchs addMatchs(@RequestBody Matchs matchs) {
        return matchsService.saveMatchs(matchs);
    }

    @GetMapping("/matchs")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public List<Matchs> findAllMatchss() {
        return matchsService.getAllMatchss();
    }

    @GetMapping("/matchs/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public Matchs findMatchsById(@PathVariable long id) {
        return matchsService.getMatchs(id);
    }

    @DeleteMapping("/matchs/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public String deleteMatchs(@PathVariable long id) {
        return matchsService.deleteMatchs(id);
    }

    @PutMapping("/matchs")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public void updateMatchs(
            @PathVariable("id") Long id,
            @RequestBody Matchs updateMatchs
    ) throws ResourceNotFoundException {
        matchsService.updateMatchs(id,updateMatchs);
    }
}
