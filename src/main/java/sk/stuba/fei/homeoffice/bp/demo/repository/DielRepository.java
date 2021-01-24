package sk.stuba.fei.homeoffice.bp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.stuba.fei.homeoffice.bp.demo.data.Diel;

@Repository
public interface DielRepository extends JpaRepository<Diel, Integer> {

    Diel findDielByIdDielu(Integer idDielu);
    Diel getDielByIdDielu(Integer idDielu);
}
