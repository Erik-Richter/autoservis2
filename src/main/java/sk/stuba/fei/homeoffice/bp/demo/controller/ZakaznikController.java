package sk.stuba.fei.homeoffice.bp.demo.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sk.stuba.fei.homeoffice.bp.demo.data.Zakaznik;
import sk.stuba.fei.homeoffice.bp.demo.repository.VozidloRepository;
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


    @GetMapping("/zmazanieZakaznika/{idenetifikator}")
    public String deleteByIdenetifikator(@PathVariable Integer idenetifikator){
        try {
            zakaznikRepository.deleteById(idenetifikator);
            return "redirect:/zoznamZakaznikov";
        }catch (Exception e){
            return "redirect:/zoznamZakaznikov";
        }
    }

}
