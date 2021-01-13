package sk.stuba.fei.homeoffice.bp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.stuba.fei.homeoffice.bp.demo.data.Zakaznik;

@Repository
public interface ZakaznikRepository extends JpaRepository<Zakaznik, Integer> {
    Zakaznik findZakaznikByIdenetifikator(Integer idenetifikator);
    Zakaznik getZakaznikByIdenetifikator(Integer idenetifikator);
}
