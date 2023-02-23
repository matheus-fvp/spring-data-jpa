package br.com.treinaweb.twprojetos.repositories;

import br.com.treinaweb.twprojetos.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
