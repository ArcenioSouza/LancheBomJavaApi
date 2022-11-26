package br.com.lanchebom.services;


import br.com.lanchebom.models.dto.request.AdicionalRequestDto;
import br.com.lanchebom.models.entity.Adicional;
import br.com.lanchebom.models.repository.AdicionalRepository;


import java.util.List;

public class AdicionalService {

    public Adicional save(AdicionalRepository adicionalRepository, AdicionalRequestDto adicionalRequestDto){
        return adicionalRepository.save(new Adicional(adicionalRequestDto.getNome(), adicionalRequestDto.getPreco()));
    }

    public List<Adicional> getAll(AdicionalRepository adicionalRepository){
        return adicionalRepository.findAll();
    }

    public Adicional getOne(AdicionalRepository adicionalRepository, Long id){
        return adicionalRepository.getReferenceById(id);
    }

    public Adicional update(AdicionalRepository adicionalRepository, Long id, AdicionalRequestDto adicionalRequestDto){
        Adicional lanche = adicionalRepository.getReferenceById(id);
        lanche.setNome(adicionalRequestDto.getNome());
        lanche.setPreco(adicionalRequestDto.getPreco());
        return lanche;
    }


    public void delete(AdicionalRepository adicionalRepository, Long id) {
        adicionalRepository.deleteById(id);
    }
}
