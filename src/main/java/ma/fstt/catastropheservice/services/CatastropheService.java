package ma.fstt.catastropheservice.services;

import lombok.Data;
import ma.fstt.catastropheservice.entities.Catastrophe;
import ma.fstt.catastropheservice.entities.Coordonnees;
import ma.fstt.catastropheservice.repositories.CatastropheRepo;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class CatastropheService {


    private final CatastropheRepo catastropheRepo;

    public CatastropheService(CatastropheRepo catastropheRepo) {
        this.catastropheRepo = catastropheRepo;
    }

    public List<Catastrophe> findAllCatastrophes(){
        return catastropheRepo.findAll();
    }

    public Catastrophe findCatastropheById(Long id){
        return catastropheRepo.findById(id).orElse(null);
    }

    public Catastrophe findCatastropheByLieu(String lieu){
        return catastropheRepo.findByLieu(lieu);
    }

    public Catastrophe findCatastropheByDate(Date date){
        return catastropheRepo.findByDate(date);
    }

    public List<Catastrophe> findAllCatastrophesByGraviteDescendante(){
        return catastropheRepo.findAllByOrderByGraviteDesc();
    }

    public Coordonnees findCatastropheCoordonneesById(Long id) {
        return catastropheRepo.findCatastropheCoordonneesById(id);
    }


    public void saveCatastrophe(Catastrophe catastrophe){
        catastropheRepo.save(catastrophe);
    }

    public void deleteCatastropheById(Long id){
        catastropheRepo.deleteById(id);
    }

}
