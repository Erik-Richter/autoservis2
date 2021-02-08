package sk.stuba.fei.homeoffice.bp.demo.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "zoznam_servisnych_zaznamov")
public class ServisnyZaznam {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id_zaznamu")
    private int idZaznamu;
    @Column(name = "nazov_zaznamu")
    private String nazovZaznamu;
    @Column(name = "datum_servisu")
    private Date datumServisu;
    @Column(name = "stav_kilometrov")
    private int stavKilometrov;
    @Column(name = "poznamky")
    private String poznamky;
    @Column(name = "id_vozidla")
    private int idVozidla;
    @Column(name = "id_majitela")
    private int idMajitela;
}
