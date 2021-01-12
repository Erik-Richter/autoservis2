package sk.stuba.fei.homeoffice.bp.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.stuba.fei.homeoffice.bp.demo.Zakaznik;

@Repository
public interface ZakaznikRepository extends JpaRepository<Zakaznik, Integer> {
}
