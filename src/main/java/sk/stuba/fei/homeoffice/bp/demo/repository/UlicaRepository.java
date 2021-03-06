package sk.stuba.fei.homeoffice.bp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.stuba.fei.homeoffice.bp.demo.data.Ulica;

@Repository
public interface UlicaRepository extends JpaRepository<Ulica, Integer> {

    Ulica getUlicaByUlicaAndObce(String ulica, String obec);
}
