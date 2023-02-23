package br.com.treinaweb.twprojetos.repositories;

import br.com.treinaweb.twprojetos.models.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
