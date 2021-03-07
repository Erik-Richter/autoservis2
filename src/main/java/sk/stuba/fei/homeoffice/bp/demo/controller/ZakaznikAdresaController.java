package sk.stuba.fei.homeoffice.bp.demo.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sk.stuba.fei.homeoffice.bp.demo.data.Adresa;
import sk.stuba.fei.homeoffice.bp.demo.data.Ulica;
import sk.stuba.fei.homeoffice.bp.demo.data.Zakaznik;
import sk.stuba.fei.homeoffice.bp.demo.repository.AdresaRepository;
import sk.stuba.fei.homeoffice.bp.demo.repository.UlicaRepository;
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
    @Autowired
    private UlicaRepository ulicaRepository;

    public ZakaznikAdresaController(ZakaznikRepository zakaznikRepository, AdresaRepository adresaRepository, UlicaRepository ulicaRepository) {
        this.zakaznikRepository = zakaznikRepository;
        this.adresaRepository = adresaRepository;
        this.ulicaRepository = ulicaRepository;
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

        /**String zPSC = zakaznik.getPsc().replaceAll("\\s", "");
        String zObec = zakaznik.getObec();
        zPSC = kontrolaAdresy(zPSC);

        if(kontrolaAdresy(zObec, zPSC) == 1){       // todo: ?=> Najlepší spôsob overovania/autodoplnania adresy ? (Podla PSC?/ obce)
            this.zakaznikRepository.save(zakaznik);
            return "vyplnene";
        }
        return "novyZakaznik";**/

        String zObec = zakaznik.getObec();
        String zUlica = zakaznik.getUlica();

        Adresa adresa = adresaRepository.getAdresaByObec(zObec);
        doplnenieAdresnychUdajovZakaznika(zakaznik, adresa);

        if (adresa.getPsc() == null){
            Ulica ulica = ulicaRepository.getUlicaByUlicaAndObce(zUlica, zObec);
            zakaznik.setPsc(ulica.getPsc());
            zakaznik.setNajblizsiaPosta(ulica.getDposta());
        }

        this.zakaznikRepository.save(zakaznik);
        return "vyplnene";
    }

    public void doplnenieAdresnychUdajovZakaznika(Zakaznik zakaznik, Adresa adresa){

        zakaznik.setPsc(adresa.getPsc()); // TODO: Ak existuje viac rovnakych obci, vyzvat zakaznika aby vyplnil psc, potom skontrolovat
        zakaznik.setOkres(adresa.getOkres());
        zakaznik.setKraj(transformaciaKrajov(adresa.getKraj()));
        zakaznik.setNajblizsiaPosta(adresa.getDposta());
    }

    public String transformaciaKrajov(String kraj){
        switch (kraj){
            case "BL": kraj = "Bratislavský kraj"; break;
            case "TA": kraj = "Trnavský kraj"; break;
            case "TC": kraj = "Trenčiansky kraj"; break;
            case "NI": kraj = "Nitriansky kraj"; break;
            case "ZI": kraj = "Žilinský kraj"; break;
            case "BC": kraj = "Banskobystrický kraj"; break;
            case "PV": kraj = "Prešovský kraj"; break;
            case "KI": kraj = "Košický kraj"; break;
            default: return null;
        }
        return kraj;
    }

    /**public String kontrolaAdresy(String psc){
        if (psc.length()!=5){
            throw new IllegalArgumentException("Nespravna dlzka PSC!");
        }
        return psc.substring(0,3) + " " + psc.substring(3);
    }

    public int kontrolaAdresy(String obec, String psc){
        for (Adresa adresa : adresaRepository.findAllByObec(obec)){
            if (adresa.getPsc().equals(psc)){
                return 1;
            }
        }
        return 0;
    }**/

    @GetMapping("/adresy")
    public String vypisAdries(Model model) {
        model.addAttribute("adresy", adresaRepository.findAll());
        return "zoznamAdries";
    }
}
