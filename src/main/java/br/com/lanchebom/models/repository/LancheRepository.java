package br.com.lanchebom.models.repository;

import br.com.lanchebom.models.entity.Lanche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface LancheRepository extends JpaRepository<Lanche, Integer> {
}
