package mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mvc.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

}