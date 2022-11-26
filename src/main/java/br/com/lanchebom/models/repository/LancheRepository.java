package br.com.lanchebom.models.repository;

import br.com.lanchebom.models.entity.Lanche;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancheRepository extends JpaRepository<Lanche, Long> {
}
