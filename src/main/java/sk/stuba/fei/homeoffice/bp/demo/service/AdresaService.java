package sk.stuba.fei.homeoffice.bp.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.homeoffice.bp.demo.repository.AdresaRepository;

@AllArgsConstructor
@Service
public class AdresaService {

    @Autowired
    private AdresaRepository adresaRepository;
}
