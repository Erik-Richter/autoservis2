package sk.stuba.fei.homeoffice.bp.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZakaznikRepository extends JpaRepository<Zakaznik, Integer> {
}
