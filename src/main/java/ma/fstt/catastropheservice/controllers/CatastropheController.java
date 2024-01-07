package ma.fstt.catastropheservice.controllers;


import ma.fstt.catastropheservice.entities.Catastrophe;
import ma.fstt.catastropheservice.entities.Coordonnees;
import ma.fstt.catastropheservice.services.CatastropheService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("catastrophe")
@CrossOrigin
public class CatastropheController {

    private final CatastropheService catastropheService;

    public CatastropheController(CatastropheService catastropheService) {
        this.catastropheService = catastropheService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> findAllCatastrophes(){
        List<Catastrophe> catastrophes = catastropheService.findAllCatastrophes();
        Map<String, Object> response = new HashMap<>();
        response.put("data", catastrophes);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<Map<String, Object>> findCatastropheById(@PathVariable("id") Long id){
        Catastrophe catastrophe = catastropheService.findCatastropheById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("data", catastrophe);
        return ResponseEntity.ok(response);
    }

    @GetMapping("lieu/{lieu}")
    public ResponseEntity<Map<String, Object>> findCatastropheByLieu(@PathVariable("lieu") String lieu){
        Catastrophe catastrophe = catastropheService.findCatastropheByLieu(lieu);
        Map<String, Object> response = new HashMap<>();
        response.put("data", catastrophe);
        return ResponseEntity.ok(response);
    }

    @GetMapping("gravite-desc")
    public ResponseEntity<Map<String, Object>> findAllCatastrophesByGraviteDescendante(){
        List<Catastrophe> catastrophes = catastropheService.findAllCatastrophesByGraviteDescendante();
        Map<String, Object> response = new HashMap<>();
        response.put("data", catastrophes);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/coordonnees/{id}")
    public ResponseEntity<Map<String, Object>> findCatastropheCoordonneesXAndCoordonneesYById(@PathVariable("id") Long id) {
        Coordonnees coordonnees = catastropheService.findCatastropheCoordonneesById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("data", coordonnees);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> saveCatastrophe(@RequestBody Catastrophe catastrophe){
        catastropheService.saveCatastrophe(catastrophe);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "saved");
        return ResponseEntity.ok(response);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Map<String, Object>> updateCatastrophe(@PathVariable("id") Long id, @RequestBody Catastrophe catastrophe){
        catastrophe.setId(id);
        catastropheService.saveCatastrophe(catastrophe);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "updated");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, Object>> deleteCatastropheById(Long id){
        catastropheService.deleteCatastropheById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "deleted");
        return ResponseEntity.ok(response);
    }
}
