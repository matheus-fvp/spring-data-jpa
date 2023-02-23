package br.com.treinaweb.twprojetos.repositories;

import br.com.treinaweb.twprojetos.models.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
}
