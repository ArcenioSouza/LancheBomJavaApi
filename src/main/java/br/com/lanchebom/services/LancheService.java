package br.com.lanchebom.services;

import br.com.lanchebom.models.dto.request.LancheRequestDto;
import br.com.lanchebom.models.entity.Lanche;
import br.com.lanchebom.models.repository.LancheRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancheService {

    private final LancheRepository lancheRepository;

    public LancheService(LancheRepository lancheRepository) {
        this.lancheRepository = lancheRepository;
    }

    public Lanche save(LancheRequestDto lancheRequestDto){
        return lancheRepository.save(new Lanche(lancheRequestDto.getNome(), lancheRequestDto.getPreco()));
    }

    public List<Lanche> getAll(){
        return lancheRepository.findAll();
    }

    public Lanche getOne(Long id){
        return lancheRepository.getReferenceById(id);
    }

    public Lanche update(Long id, LancheRequestDto lancheRequestDto){
        Lanche lanche = lancheRepository.getReferenceById(id);
        lanche.setNome(lancheRequestDto.getNome());
        lanche.setPreco(lancheRequestDto.getPreco());
        return lanche;
    }


    public void delete(Long id) {
        lancheRepository.deleteById(id);
    }
}
