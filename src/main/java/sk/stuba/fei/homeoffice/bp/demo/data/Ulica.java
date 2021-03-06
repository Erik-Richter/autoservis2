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
@Table(name = "ulice")
public class Ulica {


    private String dulica;
    @Id
    private String ulica;
    private String psc;
    private String dposta;
    private String posta;
    private String poznamka;
    private String obce;
}
