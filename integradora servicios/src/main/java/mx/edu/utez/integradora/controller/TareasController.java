package mx.edu.utez.integradora.controller;

import mx.edu.utez.integradora.model.Tareas;
import mx.edu.utez.integradora.service.TareasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/tareas")
@CrossOrigin(origins = "*")
public class TareasController {
    private final TareasService tareasService;

    public TareasController(TareasService tareasService) {
        this.tareasService = tareasService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Tareas>> findAll(){
       return new ResponseEntity<>(tareasService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/pending")
    public ResponseEntity<List<Tareas>> findAllPending(){
        return new ResponseEntity<>(tareasService.getAllPending(1), HttpStatus.OK);
    }

    @GetMapping("/programadas")
    public ResponseEntity<List<Tareas>> findAllProgramadas(){
        return new ResponseEntity<>(tareasService.getAllProgramadas(2), HttpStatus.OK);
    }
    @GetMapping("/completadas")
    public ResponseEntity<List<Tareas>> findAllCompletadas(){
        return new ResponseEntity<>(tareasService.getAllCompletadas(3), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<Tareas> createOrUpdate(@RequestBody TareaDto tareaDto){
        return new ResponseEntity<>(tareasService.createOrUpdate(tareaDto.toEntity()), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id){
        tareasService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findFirstById(@PathVariable Integer id){
        return new ResponseEntity(tareasService.getById(id), HttpStatus.OK);
    }

}
