package ma.fstt.catastropheservice.repositories;

import ma.fstt.catastropheservice.entities.Catastrophe;
import ma.fstt.catastropheservice.entities.Coordonnees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface CatastropheRepo extends JpaRepository<Catastrophe, Long> {

    @Query("SELECT new ma.fstt.catastropheservice.entities.Coordonnees(c.coordonnees_x, c.coordonnees_y) FROM Catastrophe c WHERE c.id = ?1")
    Coordonnees findCatastropheCoordonneesById(Long id);
    Catastrophe findByLieu(String lieu);

    Catastrophe findByDate(Date date);
    Catastrophe findByGravite(Integer gravite);

    List<Catastrophe> findAllByOrderByGraviteDesc();



}
