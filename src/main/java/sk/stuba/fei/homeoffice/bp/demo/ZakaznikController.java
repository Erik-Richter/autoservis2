package sk.stuba.fei.homeoffice.bp.demo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
    public String index(Model model) {
        Zakaznik zakaznik = new Zakaznik();
        model.addAttribute("zakaznik", zakaznik);

        return "novyZakaznik";
    }

    @PostMapping("/novyZakaznik")
    public String novyPouzivatel(@ModelAttribute @Valid Zakaznik zakaznik, Model model) {

        this.zakaznikRepository.save(zakaznik);
        return "vyplnene";
    }
}
