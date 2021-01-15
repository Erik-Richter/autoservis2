package sk.stuba.fei.homeoffice.bp.demo.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sk.stuba.fei.homeoffice.bp.demo.data.Zakaznik;
import sk.stuba.fei.homeoffice.bp.demo.repository.ZakaznikRepository;

import javax.validation.Valid;

@Controller
@Component
@Data
public class ZakaznikController{

    @Autowired
    private ZakaznikRepository zakaznikRepository;

    public ZakaznikController(ZakaznikRepository zakaznikRepository) {
        this.zakaznikRepository = zakaznikRepository;
    }

    @GetMapping
    public String vypisVsetkychZakaznikov(Model model){
        model.addAttribute("zakaznici", zakaznikRepository.findAll());
        return "index";
    }

    @GetMapping("/novyZakaznik")
    public String registracia(Model model) {
        Zakaznik zakaznik = new Zakaznik();
        model.addAttribute("zakaznik", zakaznik);
        return "novyZakaznik";
    }

    @PostMapping("/novyZakaznik")
    public String novyPouzivatel(@ModelAttribute @Valid Zakaznik zakaznik, Model model) {

        this.zakaznikRepository.save(zakaznik);
        return "vyplnene";
    }

    @GetMapping("/detail/{idenetifikator}")
    public String findZakaznikByIdenetifikator(@PathVariable Integer idenetifikator, Model model){
        model.addAttribute("zakaznik", this.zakaznikRepository.findZakaznikByIdenetifikator(idenetifikator));
        return "vyplnene";
    }

    @GetMapping("/zmenaUdajov/{idenetifikator}")
    public String getZakaznikByIdenetifikator(@PathVariable Integer idenetifikator, Model model){
        model.addAttribute("zakaznik", this.zakaznikRepository.getZakaznikByIdenetifikator(idenetifikator));
        return "novyZakaznik";
    }

    /*
    @GetMapping("/zmazanieZakaznika/{idenetifikator}")
    public String deleteByIdenetifikator(@PathVariable Integer idenetifikator, Model model){
        model.addAttribute("zakaznik", this.zakaznikRepository.deleteByIdenetifikator(idenetifikator));
        return "index";
    }
    */
}
