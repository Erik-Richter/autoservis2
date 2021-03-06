package sk.stuba.fei.homeoffice.bp.demo.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sk.stuba.fei.homeoffice.bp.demo.repository.UlicaRepository;

@Component
@Controller
@Data
@AllArgsConstructor
public class UlicaController {

    private UlicaRepository ulicaRepository;

    @GetMapping("/ulice")
    public String vypisAdriesPSC(Model model){
    model.addAttribute("ulice", ulicaRepository.findAll());
    return "zoznamUlic";
    }
}
