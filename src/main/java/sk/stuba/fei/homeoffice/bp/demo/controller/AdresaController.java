package sk.stuba.fei.homeoffice.bp.demo.controller;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sk.stuba.fei.homeoffice.bp.demo.repository.AdresaRepository;

@Controller
@Component
@Data
public class AdresaController {

    private AdresaRepository adresaRepository;

    public AdresaController(AdresaRepository adresaRepository) {
        this.adresaRepository = adresaRepository;
    }



}
