package com.example.appStudents.controller;

import com.example.appStudents.dto.EstudiantesDTO;
import com.example.appStudents.model.Estudiantes;
import com.example.appStudents.service.EstudiantesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudiantesController {

    private final EstudiantesService estudiantesService;

    // Constructor que inyecta el servicio de estudiantes
    public EstudiantesController(EstudiantesService estudiantesService) {
        this.estudiantesService = estudiantesService;
    }

    // Endpoint para crear un nuevo estudiante
    @PostMapping
    public ResponseEntity<EstudiantesDTO> crear(@RequestBody EstudiantesDTO dto) {
        Estudiantes nuevo = estudiantesService.guardarEstudiante(dto);
        return ResponseEntity.ok(convertToDTO(nuevo));
    }

    // Endpoint para obtener todos los estudiantes
    @GetMapping
    public ResponseEntity<List<EstudiantesDTO>> listar() {
        List<Estudiantes> lista = estudiantesService.obtenerTodos();
        List<EstudiantesDTO> dtos = new ArrayList<>();

        // Convertimos cada estudiante a su DTO
        for (Estudiantes estudiante : lista) {
            dtos.add(convertToDTO(estudiante));
        }

        return ResponseEntity.ok(dtos);
    }

    // Endpoint para obtener un estudiante por su ID
    @GetMapping("/{id}")
    public ResponseEntity<EstudiantesDTO> obtenerPorId(@PathVariable Long id) {
        Estudiantes estudiante = estudiantesService.obtenerPorId(id);
        return estudiante != null
                ? ResponseEntity.ok(convertToDTO(estudiante))
                : ResponseEntity.notFound().build();
    }

    // Endpoint para actualizar un estudiante existente
    @PutMapping("/{id}")
    public ResponseEntity<EstudiantesDTO> actualizar(@PathVariable Long id, @RequestBody EstudiantesDTO dto) {
        Estudiantes actualizado = estudiantesService.actualizar(id, dto);
        return actualizado != null
                ? ResponseEntity.ok(convertToDTO(actualizado))
                : ResponseEntity.notFound().build();
    }

    // Endpoint para eliminar un estudiante por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        estudiantesService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // Método auxiliar para convertir entidad Estudiantes a DTO
    private EstudiantesDTO convertToDTO(Estudiantes estudiante) {
        EstudiantesDTO dto = new EstudiantesDTO();

        dto.setId(estudiante.getId());
        dto.setIdEstudiante(estudiante.getIdEstudiante());
        dto.setNombre(estudiante.getNombre());
        dto.setApellido(estudiante.getApellido());
        dto.setFechaNacimiento(estudiante.getFechaNacimiento());
        dto.setGenero(estudiante.getGenero());
        dto.setGrado(estudiante.getGrado());
        dto.setDireccion(estudiante.getDireccion());
        dto.setTelefono(estudiante.getTelefono());
        dto.setEmail(estudiante.getEmail());
        dto.setFechaIngreso(estudiante.getFechaIngreso());

        if (estudiante.getCurso() != null) {
            dto.setCursoId(estudiante.getCurso().getId());
        }

        return dto;
    }
}









