package sk.stuba.fei.homeoffice.bp.demo.controller;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sk.stuba.fei.homeoffice.bp.demo.data.ServisnyZaznam;
import sk.stuba.fei.homeoffice.bp.demo.repository.ServisnyZaznamRepository;

@Controller
@Component
@Data
public class ServisnyZaznamController {

    private ServisnyZaznamRepository servisnyZaznamRepository;

    public ServisnyZaznamController(ServisnyZaznamRepository servisnyZaznamRepository) {
        this.servisnyZaznamRepository = servisnyZaznamRepository;
    }

    @GetMapping("/zoznamServisnychZaznamov")
    public String vypisServisnychZaznamov(Model model){
        model.addAttribute("servisneZaznamy", servisnyZaznamRepository.findAll());
        return "zoznamServisnychZaznamov";
    }

    @GetMapping("/novyServisnyZaznam")
    public String novyServisnyZaznam(Model model){
        ServisnyZaznam servisnyZaznam = new ServisnyZaznam();
        model.addAttribute("servisnyZaznam", servisnyZaznam);
        return "novyServisnyZaznam";
    }

    @PostMapping("/novyServisnyZaznam")
    public String udajeServisnehoZaznamu(@ModelAttribute ServisnyZaznam servisnyZaznam){
        this.servisnyZaznamRepository.save(servisnyZaznam);
        return "udajeServisnehoZaznamu";
    }

    @GetMapping("/zoznamServisnychZaznamov/detail/{idZaznamu}")
    public String findServisnyZaznamByIdZaznamu(@PathVariable Integer idZaznamu, Model model){
        model.addAttribute("servisnyZaznam", this.servisnyZaznamRepository.findServisnyZaznamByIdZaznamu(idZaznamu));
        return "udajeServisnehoZaznamu";
    }

    @GetMapping("/zoznamServisnychZaznamov/zmenaUdajov/{idZaznamu}")
    public String getServisnyZaznamByIdZaznamu(@PathVariable Integer idZaznamu, Model model){
        model.addAttribute("servisnyZaznam", this.servisnyZaznamRepository.getServisnyZaznamByIdZaznamu(idZaznamu));
        return "novyServisnyZaznam";
    }

    @GetMapping("zoznamServisnychZaznamov/zmazanie/{idZaznamu}")
    public String deleteServisnyZaznamById(@PathVariable Integer idZaznamu){
        servisnyZaznamRepository.deleteById(idZaznamu);
        return "redirect:/zoznamServisnychZaznamov";
    }
}
