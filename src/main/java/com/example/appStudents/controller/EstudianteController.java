package com.example.appStudents.controller;

import com.example.appStudents.model.Estudiante;
import com.example.appStudents.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping
    public Estudiante addEstudiante(@RequestBody Estudiante estudiante){
        return estudianteService.saveEstudiante(estudiante);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> getEstudianteId(@PathVariable Long id){
        Optional<Estudiante> estudiante = estudianteService.getEstudianteId(id);
        return estudiante.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Estudiante updateEstudianteId(@PathVariable Long id, @RequestBody Estudiante estudiante){
        return estudianteService.updateEstudiante(id, estudiante);
    }

    @DeleteMapping("{id}")
    public void deleteEstudiante(@PathVariable Long id){
        estudianteService.deleteEstudiante(id);
    }



    // Obtener lista de todos los estudiantes
//    @GetMapping
//    public List<Estudiante> listar() {
//        return service.listar();
//    }
//
//    // Crear estudiante asociado a un maestro
//    @PostMapping("/maestro/{idMaestro}")
//    public Estudiante guardar(@RequestBody Estudiante estudiante, @PathVariable Long idMaestro) {
//        return service.guardar(estudiante, idMaestro);
//    }
//
//    // Eliminar estudiante por ID
//    @DeleteMapping("/{id}")
//    public void eliminar(@PathVariable Long id) {
//        service.eliminar(id);
//    }
}



