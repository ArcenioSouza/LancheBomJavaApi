package br.com.lanchebom.services;


import br.com.lanchebom.models.dto.request.AdicionalRequestDto;
import br.com.lanchebom.models.entity.Adicional;
import br.com.lanchebom.models.repository.AdicionalRepository;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class AdicionalService {

    private final AdicionalRepository adicionalRepository;

    public AdicionalService(AdicionalRepository adicionalRepository) {
        this.adicionalRepository = adicionalRepository;
    }

    public Adicional save(AdicionalRequestDto adicionalRequestDto){
        return adicionalRepository.save(new Adicional(adicionalRequestDto.getNome(), adicionalRequestDto.getPreco()));
    }

    public List<Adicional> getAll(){
        return adicionalRepository.findAll();
    }

    public Adicional getOne(Long id){
        return adicionalRepository.getReferenceById(id);
    }

    public Adicional update(Long id, AdicionalRequestDto adicionalRequestDto){
        Adicional lanche = adicionalRepository.getReferenceById(id);
        lanche.setNome(adicionalRequestDto.getNome());
        lanche.setPreco(adicionalRequestDto.getPreco());
        return lanche;
    }


    public void delete(Long id) {
        adicionalRepository.deleteById(id);
    }
}
