package br.com.lanchebom.services;

import br.com.lanchebom.models.dto.request.LancheRequestDto;
import br.com.lanchebom.models.entity.Lanche;
import br.com.lanchebom.models.repository.LancheRepository;
import java.util.List;
import java.util.Optional;

public class LancheService {

    public Lanche save(LancheRepository lancheRepository, LancheRequestDto lancheRequestDto){
        return lancheRepository.save(new Lanche(lancheRequestDto.getNome(), lancheRequestDto.getPreco()));
    }

    public List<Lanche> getAll(LancheRepository lancheRepository){
        return lancheRepository.findAll();
    }

    public Lanche getOne(LancheRepository lancheRepository, int id){
        return lancheRepository.getReferenceById(id);
    }
}
