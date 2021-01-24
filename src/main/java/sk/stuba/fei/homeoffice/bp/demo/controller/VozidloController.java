package sk.stuba.fei.homeoffice.bp.demo.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sk.stuba.fei.homeoffice.bp.demo.data.Vozidlo;
import sk.stuba.fei.homeoffice.bp.demo.repository.VozidloRepository;


@Controller
@Component
@Data
public class VozidloController {

    private VozidloRepository vozidloRepository;

    public VozidloController(VozidloRepository vozidloRepository) {
        this.vozidloRepository = vozidloRepository;
    }

    @GetMapping("/zoznamVozidiel")
    public String vypisVozidiel(Model model){
        model.addAttribute("vozidla", vozidloRepository.findAll());
        return "zoznamVozidiel";
    }

    @GetMapping("/noveVozidlo")
    public String noveVozidlo(Model model){
        Vozidlo vozidlo = new Vozidlo();
        model.addAttribute("vozidlo", vozidlo);
        return "noveVozidlo";
    }

    @PostMapping("/noveVozidlo")
    public String udajeVozidla(@ModelAttribute Vozidlo vozidlo){
        this.vozidloRepository.save(vozidlo);
        return "udajeVozidla";
    }

    @GetMapping("/zoznamVozidiel/detailVozidla/{idVozidla}")
    public String findVozidloByIdVozidla(@PathVariable Integer idVozidla, Model model){
        model.addAttribute("vozidlo", this.vozidloRepository.findVozidloByIdVozidla(idVozidla));
        return "udajeVozidla";
    }

    @GetMapping("/zoznamVozidiel/zmenaUdajovVozidla/{idVozidla}")
    public String getVozidloById(@PathVariable Integer idVozidla, Model model){
        model.addAttribute("vozidlo", this.vozidloRepository.getVozidloByIdVozidla(idVozidla));
        return "noveVozidlo";
    }

    @GetMapping("/zoznamVozidiel/odstranenieVozidla/{idVozidla}")
    public String deleteVozidloById(@PathVariable Integer idVozidla){
        vozidloRepository.deleteById(idVozidla);
        return "redirect:/zoznamVozidiel";
    }

    @GetMapping("/noveVozidlo/zakaznik/{idMajitela}")
    public String noveVozidloZakaznika(@PathVariable Integer idMajitela, Model model){
        Vozidlo vozidlo = new Vozidlo();
        vozidlo.setIdMajitela(idMajitela);
        model.addAttribute("vozidlo", vozidlo);
        return "noveVozidlo";
    }

    @GetMapping("/zoznamVozidiel/zakaznik/{idMajitela}")
    public String zobrazenieVozidielZakaznika(@PathVariable Integer idMajitela, Model model){
        model.addAttribute("vozidla", vozidloRepository.findAllByIdMajitela(idMajitela));
        return "zoznamVozidiel";
    }
}
