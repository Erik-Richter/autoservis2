package sk.stuba.fei.homeoffice.bp.demo.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "diely")
public class Diel {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id")
    private int idDielu;
    @Column(name = "nazov")
    private String nazov;
    @Column(name = "pocet")
    private int pocet;
    @Column(name = "vyrobca")
    private String vyrobca;
    @Column(name = "cislo_produktu")
    private String cisloProduktu;
    @Column(name = "typove_cislo")
    private String typoveCislo;
    @Column(name = "kategoria")
    private String kategoria;
}
