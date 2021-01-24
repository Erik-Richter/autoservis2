package sk.stuba.fei.homeoffice.bp.demo.controller;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sk.stuba.fei.homeoffice.bp.demo.data.Diel;
import sk.stuba.fei.homeoffice.bp.demo.repository.DielRepository;

@Controller
@Component
@Data
public class DielController {

    private DielRepository dielRepository;

    public DielController(DielRepository dielRepository) {
        this.dielRepository = dielRepository;
    }

    @GetMapping("/zoznamDielov")
    public String vypisDielov(Model model){
        model.addAttribute("diely", dielRepository.findAll());
        return "zoznamDielov";
    }

    @GetMapping("/novyDiel")
    public String novyDiel(Model model){
        Diel diel = new Diel();
        model.addAttribute("diel", diel);
        return "novyDiel";
    }

    @PostMapping("/novyDiel")
    public String udajeDielu(@ModelAttribute Diel diel){
        this.dielRepository.save(diel);
        return "udajeDielu";
    }

    @GetMapping("/zoznamDielov/diel/{idDielu}")
    public String findDielByIdDielu(@PathVariable Integer idDielu, Model model){
        model.addAttribute("diel", this.dielRepository.findDielByIdDielu(idDielu));
        return "udajeDielu";
    }

    @GetMapping("/zoznamDielov/zmenaUdajov/{idDielu}")
    public String getDielById(@PathVariable Integer idDielu, Model model){
        model.addAttribute("diel", this.dielRepository.getDielByIdDielu(idDielu));
        return "novyDiel";
    }

    @GetMapping("/zoznamDielov/odstranenieDielu/{idDielu}")
    public String deleteVozidloById(@PathVariable Integer idDielu){
        dielRepository.deleteById(idDielu);
        return "redirect:/zoznamDielov";
    }
}
