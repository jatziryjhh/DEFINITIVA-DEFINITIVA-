package mx.edu.utez.integradora.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareasRepository extends JpaRepository<Tareas, Integer> {
    List<Tareas> findAllByEstado(Integer id);

    Tareas findFirstById(Integer id);
}
