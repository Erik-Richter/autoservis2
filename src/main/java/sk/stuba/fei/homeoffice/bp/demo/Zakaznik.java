package sk.stuba.fei.homeoffice.bp.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tabulkaZakaznikov")
public class Zakaznik {

    @Id
    @Column(name = "idenetifikator")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idenetifikator;
    @Column(name = "meno")
    private String meno;
}
