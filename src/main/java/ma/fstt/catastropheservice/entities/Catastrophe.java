package ma.fstt.catastropheservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Catastrophe {
    @Id
    @GeneratedValue
    private Long id;

    private String titre;
    private Date date;
    private String lieu;
    private Float coordonnees_x;
    private Float coordonnees_y;
    private String informations;
    private Integer gravite;
}
