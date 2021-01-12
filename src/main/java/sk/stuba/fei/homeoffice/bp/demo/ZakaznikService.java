package sk.stuba.fei.homeoffice.bp.demo;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ZakaznikService {

    @Autowired
    private ZakaznikRepository zakaznikRepository;
}
