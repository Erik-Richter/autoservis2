package sk.stuba.fei.homeoffice.bp.demo.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table (name = "vozidla")
public class Vozidlo {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id_vozidla")
    private int idVozidla;
    @Column(name = "id_majitela")
    private int idMajitela;
    @Column(name = "znacka_vozidla")
    private String znackaVozidla;
    @Column(name = "typ_vozidla")
    private String typVozidla;
    @Column(name = "vin_cislo")
    private String vinCislo;
}
