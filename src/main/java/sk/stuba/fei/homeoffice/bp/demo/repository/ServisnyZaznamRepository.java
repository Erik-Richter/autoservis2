package sk.stuba.fei.homeoffice.bp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.stuba.fei.homeoffice.bp.demo.data.ServisnyZaznam;

@Repository
public interface ServisnyZaznamRepository extends JpaRepository<ServisnyZaznam, Integer> {
    ServisnyZaznam findServisnyZaznamByIdZaznamu(Integer idZaznamu);
    ServisnyZaznam getServisnyZaznamByIdZaznamu(Integer idZaznamu);
}
