package sk.stuba.fei.homeoffice.bp.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
        log.info("Zoznam zákazníkov:            http://localhost:8080/zoznamZakaznikov");
        log.info("Zoznam vozidiel:              http://localhost:8080/zoznamVozidiel");
        log.info("Zoznam Servisných záznamov:   http://localhost:8080/zoznamServisnychZaznamov");
        log.info("Zoznam dielov:                http://localhost:8080/zoznamDielov");
        log.info("Zoznam dielov:                http://localhost:8080/adresy");
    }

    public void run(String... args) throws Exception {
        //System.out.println("Hello world");
    }
    // todo: napad: rodne cislo ako id, kontrola podla datumu
}
