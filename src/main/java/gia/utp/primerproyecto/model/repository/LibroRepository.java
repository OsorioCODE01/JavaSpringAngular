package gia.utp.primerproyecto.model.repository;

import gia.utp.primerproyecto.model.entities.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRepository  extends JpaRepository<LibroEntity, Integer> {
    List<LibroEntity> findAllByNombreLibro(String nombreLibro);

}
