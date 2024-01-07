package ma.fstt.catastropheservice.controllers;


import ma.fstt.catastropheservice.entities.Catastrophe;
import ma.fstt.catastropheservice.entities.Coordonnees;
import ma.fstt.catastropheservice.services.CatastropheService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("catastrophe")
@CrossOrigin
public class CatastropheController {

    private final CatastropheService catastropheService;

    public CatastropheController(CatastropheService catastropheService) {
        this.catastropheService = catastropheService;
    }

    @GetMapping
    public List<Catastrophe> findAllCatastrophes(){
        return catastropheService.findAllCatastrophes();
    }

    @GetMapping("{id}")
    public Catastrophe findCatastropheById(@PathVariable("id") Long id){
        return catastropheService.findCatastropheById(id);
    }

    @GetMapping("lieu/{lieu}")
    public Catastrophe findCatastropheByLieu(@PathVariable("lieu") String lieu){
        return catastropheService.findCatastropheByLieu(lieu);
    }

    @GetMapping("gravite-desc")
    public List<Catastrophe> findAllCatastrophesByGraviteDescendante(){
        return catastropheService.findAllCatastrophesByGraviteDescendante();
    }

    @GetMapping("/coordonnees/{id}")
    public Coordonnees findCatastropheCoordonneesXAndCoordonneesYById(@PathVariable("id") Long id) {
        return catastropheService.findCatastropheCoordonneesById(id);
    }

    @PostMapping
    public void saveCatastrophe(@RequestBody Catastrophe catastrophe){
        catastropheService.saveCatastrophe(catastrophe);
    }

    @PatchMapping("{id}")
    public void updateCatastrophe(@PathVariable("id") Long id, @RequestBody Catastrophe catastrophe){
        catastrophe.setId(id);
        catastropheService.saveCatastrophe(catastrophe);
    }

    @DeleteMapping("{id}")
    public void deleteCatastropheById(@PathVariable("id") Long id){
        catastropheService.deleteCatastropheById(id);
    }


}
