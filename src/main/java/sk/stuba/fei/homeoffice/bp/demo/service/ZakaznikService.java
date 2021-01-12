package sk.stuba.fei.homeoffice.bp.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.homeoffice.bp.demo.repository.ZakaznikRepository;

@AllArgsConstructor
@Service
public class ZakaznikService {

    @Autowired
    private ZakaznikRepository zakaznikRepository;
}
