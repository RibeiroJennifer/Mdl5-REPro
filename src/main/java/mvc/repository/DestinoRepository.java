package mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mvc.model.Destinos;

public interface DestinoRepository extends JpaRepository<Destinos, Long> {

}