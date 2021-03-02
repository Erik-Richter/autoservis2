package sk.stuba.fei.homeoffice.bp.demo.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "db_obce")
public class Adresa {

    private String dobec;
    private String obec;
    private String okres;
    private String psc;
    private String dposta;
    private String posta;
    @Id
    private int kod_okr;
    private String kraj;
}
