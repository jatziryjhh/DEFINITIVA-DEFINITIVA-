package mx.edu.utez.integradora.service;

import mx.edu.utez.integradora.model.Tareas;
import mx.edu.utez.integradora.model.TareasRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class TareasService {
    private final TareasRepository tareasRepository;

    public TareasService(TareasRepository tareasRepository) {
        this.tareasRepository = tareasRepository;
    }

    @Transactional(readOnly = true)
    public List<Tareas> findAll(){ return tareasRepository.findAll(Sort.by(Sort.Direction.DESC, "id")); }

    @Transactional(rollbackFor = {SQLException.class})
    public Tareas create(Tareas tareas){
        return tareasRepository.save(tareas);
    }
    @Transactional(rollbackFor = {SQLException.class})
    public Tareas update(Integer id, Tareas tareas){
        tareas.setId(id);
        return tareasRepository.save(tareas);
    }
    @Transactional(rollbackFor = {SQLException.class})
    public void deleteById(Integer id) {
        tareasRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Tareas getById(Integer id) {
        return tareasRepository.findFirstById(id);
    }

    @Transactional(readOnly = true)
    public List<Tareas> getAllPending(Integer id) {
       return tareasRepository.findAllByEstado(1);
    }

    @Transactional(readOnly = true)
    public List<Tareas> getAllProgramadas(Integer id) {
        return tareasRepository.findAllByEstado(2);
    }

    @Transactional(readOnly = true)
    public List<Tareas> getAllCompletadas(Integer id) {
        return tareasRepository.findAllByEstado(3);
    }
}
