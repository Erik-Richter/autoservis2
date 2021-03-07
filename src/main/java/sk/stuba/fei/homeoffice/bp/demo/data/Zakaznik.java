package sk.stuba.fei.homeoffice.bp.demo.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
public class Zakaznik {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "idenetifikator")
    private int idenetifikator;
    @Column(name = "meno")
    private String meno;
    @Column(name = "priezvisko")
    private String priezvisko;
    @Column(name = "email")
    private String email;
    @Column(name = "rodne_cislo")
    private String rodneCislo;
    @Column(name = "ulica")
    private String ulica;
    @Column(name = "cislo_domu")
    private String cisloDomu;
    @Column(name = "obec")
    private String obec;
    private String psc;
    private String okres;
    private String kraj;
    @Column(name = "najblizsia_posta")
    private String najblizsiaPosta;
    @Column(name = "datum_narodenia")
    private Date datumNarodenia;
    @Column(name = "telefonne_cislo")
    private String telefonneCislo;

    // TODO: telefonneCislo, Datum narodenia, pohlavie

    public String getAdresa() {
        String ulica = getUlica();
        String cisloDomu = getCisloDomu();
        String obec = getObec();
        String psc = getPsc();
        String okres = getOkres();
        String kraj = getKraj();

        return ulica + " " + cisloDomu + ", " + obec + " " + psc + ", okres " + okres + ", " + kraj;
    }
}
