package br.com.lanchebom.controllers;

import br.com.lanchebom.models.entity.Lanche;
import br.com.lanchebom.models.repository.LancheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/lanche")
public class LancheController {
    @Autowired
    private LancheRepository lancheRepository;

    @PostMapping
    public @ResponseBody Lanche post(Lanche lanche){
        lancheRepository.save(lanche);
        return lanche;
    }

    @GetMapping
    public Iterable<Lanche> get(){
        return lancheRepository.findAll();
    }
}
