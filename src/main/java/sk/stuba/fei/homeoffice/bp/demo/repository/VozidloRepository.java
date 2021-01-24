package sk.stuba.fei.homeoffice.bp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.stuba.fei.homeoffice.bp.demo.data.Vozidlo;

import java.util.List;

@Repository
public interface VozidloRepository extends JpaRepository<Vozidlo, Integer> {
    Vozidlo findVozidloByIdVozidla(Integer idVozidla);
    Vozidlo getVozidloByIdVozidla(Integer idVozidla);

    List<Vozidlo> findAllByIdMajitela(Integer idMajitela);
}
