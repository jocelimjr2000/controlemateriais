package materiais.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import materiais.models.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
