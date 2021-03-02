package sk.stuba.fei.homeoffice.bp.demo.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sk.stuba.fei.homeoffice.bp.demo.data.Zakaznik;
import sk.stuba.fei.homeoffice.bp.demo.repository.AdresaRepository;
import sk.stuba.fei.homeoffice.bp.demo.repository.ZakaznikRepository;

import javax.validation.Valid;

@Controller
@Component
@Data
public class ZakaznikAdresaController {

    @Autowired
    private ZakaznikRepository zakaznikRepository;
    @Autowired
    private AdresaRepository adresaRepository;

    public ZakaznikAdresaController(ZakaznikRepository zakaznikRepository, AdresaRepository adresaRepository) {
        this.zakaznikRepository = zakaznikRepository;
        this.adresaRepository = adresaRepository;
    }

    @GetMapping("/zoznamZakaznikov")
    public String vypisVsetkychZakaznikov(Model model){
        model.addAttribute("zakaznici", zakaznikRepository.findAll());
        return "zoznamZakaznikov";
    }

    @GetMapping("/novyZakaznik")
    public String registracia(Model model) {
        Zakaznik zakaznik = new Zakaznik();
        model.addAttribute("zakaznik", zakaznik);
        // todo: vymysliet kontrolu adresy
        return "novyZakaznik";
    }

    @PostMapping("/novyZakaznik")
    public String novyPouzivatel(@ModelAttribute @Valid Zakaznik zakaznik, Model model) {

        this.zakaznikRepository.save(zakaznik);
        return "vyplnene";
    }

    @GetMapping("/adresy")
    public String vypisAdries(Model model) {
        model.addAttribute("adresy", adresaRepository.findAll());
        return "zoznamAdries";
    }
}
