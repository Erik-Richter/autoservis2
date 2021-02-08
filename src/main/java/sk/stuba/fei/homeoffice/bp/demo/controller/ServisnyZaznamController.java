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
import sk.stuba.fei.homeoffice.bp.demo.data.Vozidlo;
import sk.stuba.fei.homeoffice.bp.demo.repository.ServisnyZaznamRepository;
import sk.stuba.fei.homeoffice.bp.demo.repository.VozidloRepository;

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

    /*@GetMapping("/novyServisnyZaznam/vozidlo/{idVozidla}")
    public String novyServisnyZaznamVozidla(@PathVariable Integer idVozidla, Model model){
        ServisnyZaznam servisnyZaznam = new ServisnyZaznam();
        // todo:servisnyZaznam.setIdMajitela = findMajitelaByIdVozidla(Integer idVozidla);

        ServisnyZaznam majitela = servisnyZaznamRepository.getFirstByIdVozidla(idVozidla);
        int idMajitela = majitela.getIdMajitela();
        servisnyZaznam.setIdMajitela(idMajitela);

        servisnyZaznam.setIdVozidla(idVozidla);
        model.addAttribute("servisnyZaznam", servisnyZaznam);
        return "novyServisnyZaznam";
    }*/

    @GetMapping("/servisnaKnizka/vozidlo/{idVozidla}")
    public String zobrazenieServisnejKnizky(@PathVariable Integer idVozidla, Model model){
        model.addAttribute("servisneZaznamy", servisnyZaznamRepository.findAllByIdVozidla(idVozidla));
        return "zoznamServisnychZaznamov";
    }

    @GetMapping("/zoznamServisnychZaznamov/zakaznik/{idMajitela}")
    public String zobrazenieVozidielZakaznika(@PathVariable Integer idMajitela, Model model){
        model.addAttribute("servisneZaznamy", servisnyZaznamRepository.findAllByIdMajitela(idMajitela));
        return "zoznamServisnychZaznamov";
    }
}
