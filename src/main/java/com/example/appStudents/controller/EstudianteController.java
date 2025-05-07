package com.example.appStudents.controller;

import com.example.appStudents.model.Estudiante;
import com.example.appStudents.service.EstudianteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    // Obtener lista de todos los estudiantes
    @GetMapping
    public List<Estudiante> listar() {
        return service.listar();
    }

    // Crear estudiante asociado a un maestro
    @PostMapping("/maestro/{idMaestro}")
    public Estudiante guardar(@RequestBody Estudiante estudiante, @PathVariable Long idMaestro) {
        return service.guardar(estudiante, idMaestro);
    }

    // Eliminar estudiante por ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}



