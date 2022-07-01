package isi.utm.tn.controller;

import isi.utm.tn.exception.ResourceNotFoundException;
import isi.utm.tn.model.Arbitre;
import isi.utm.tn.service.ArbitreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4400")
@RequestMapping("/api/v1")
public class ArbitreController {
    @Autowired
    private ArbitreService arbitreService;

    @PostMapping("/arbitre")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public Arbitre addArbitre(@RequestBody Arbitre arbitre) {
        return arbitreService.saveArbitre(arbitre);
    }
    @GetMapping("/arbitre")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public List<Arbitre> findAllArbitres() {
        return arbitreService.getAllArbitres();
    }
    @GetMapping("/arbitre/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public Arbitre findArbitreById(@PathVariable long id) {
        return arbitreService.getArbitre(id);
    }
    @DeleteMapping("/arbitre/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")

    public String deleteArbitre(@PathVariable long id) {
        return arbitreService.deleteArbitre(id);
    }
    @PutMapping("/arbitre")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public void updateArbitre(
            @PathVariable("id") Long id,
            @RequestBody Arbitre updateArbitre
    ) throws ResourceNotFoundException {
        arbitreService.updateArbitre(id,updateArbitre);
    }

}
