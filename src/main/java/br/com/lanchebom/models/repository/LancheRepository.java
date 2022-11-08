package br.com.lanchebom.models.repository;

import br.com.lanchebom.models.entity.Lanche;
import org.springframework.data.repository.CrudRepository;

public interface LancheRepository extends CrudRepository<Lanche, Integer> {
}
