package application.model.dao;

import application.model.entity.Foto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFotoRepository extends JpaRepository<Foto, Long> {
}
