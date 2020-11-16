package materiais.repositories;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import materiais.models.Filial;

@Repository
@Primary
public interface HelperRepository<T> extends JpaRepository<Filial, Long>{


}
