package sk.stuba.fei.homeoffice.bp.demo.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
}
