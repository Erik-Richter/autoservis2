package sk.stuba.fei.homeoffice.bp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.stuba.fei.homeoffice.bp.demo.data.Adresa;

@Repository
public interface AdresaRepository extends JpaRepository<Adresa, Integer> {

}
