package sk.stuba.fei.homeoffice.bp.demo;

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
@Service
public class ZakaznikController{

    List<Zakaznik> zakaznici = new ArrayList<>();

    @GetMapping
    public String vypisVsetkychZakaznikov(Model model){
        model.addAttribute("zakaznici", zakaznici);
        return "index";
    }

    @GetMapping("/novyZakaznik")
    public String index(Model model) {
        Zakaznik zakaznik = new Zakaznik();
        model.addAttribute("zakaznik", zakaznik);
        zakaznik.setIdenetifikator(zakaznici.size());
        return "novyZakaznik";
    }

    @PostMapping("/novyZakaznik")
    public String novyPouzivatel(@ModelAttribute @Valid Zakaznik zakaznik, Model model) {

        model.addAttribute("zakaznik", zakaznik);
        zakaznici.add(zakaznik);
        return "vyplnene";
    }
}
