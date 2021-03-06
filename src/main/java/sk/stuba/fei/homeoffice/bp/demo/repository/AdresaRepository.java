package sk.stuba.fei.homeoffice.bp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.stuba.fei.homeoffice.bp.demo.data.Adresa;

import java.util.List;

@Repository
public interface AdresaRepository extends JpaRepository<Adresa, Integer> {

    Adresa getAdresaByObec(String obec);
    List<Adresa> findAllByObec(String obec);
}
