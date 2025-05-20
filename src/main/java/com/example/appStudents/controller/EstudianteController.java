package com.example.appStudents.controller;

import com.example.appStudents.dto.EstudianteDTO;
import com.example.appStudents.model.Estudiante;
import com.example.appStudents.service.EstudianteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController // Esta clase controlará peticiones REST (API)
@RequestMapping("/api/estudiantes") // Ruta base para acceder a los estudiantes
public class EstudianteController {

    // Inyectamos el servicio que maneja la lógica de negocio de los estudiantes
    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    //Obtener todos los estudiantes
    @GetMapping
    public List<EstudianteDTO> getAllEstudiantes() {
        // Convertimos la lista de entidades Estudiante a una lista de DTOs para evitar enviar datos sensibles
        return estudianteService.getAllEstudiantes().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    //Obtener un estudiante por su ID
    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDTO> getEstudiante(@PathVariable Long id) {
        return estudianteService.getEstudianteById(id)
                .map(this::convertToDTO)
                .map(ResponseEntity::ok) // Devuelve 200 OK si lo encuentra
                .orElse(ResponseEntity.notFound().build()); // Devuelve 404 si no lo encuentra
    }

    //Crear un nuevo estudiante
    @PostMapping
    public ResponseEntity<?> createEstudiante(@RequestBody EstudianteDTO dto) {
        try {
            Estudiante nuevo = estudianteService.saveEstudiante(dto.getNombre(), dto.getGrupoId());
            return ResponseEntity.ok(convertToDTO(nuevo)); // Devuelve el estudiante creado
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage()); // Error si el grupo no existe
        }
    }

    //Actualizar un estudiante existente
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEstudiante(@PathVariable Long id, @RequestBody EstudianteDTO dto) {
        try {
            Estudiante actualizado = estudianteService.updateEstudiante(id, dto.getNombre(), dto.getGrupoId());
            return ResponseEntity.ok(convertToDTO(actualizado));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage()); // Error si no se encuentra
        }
    }

    //Eliminar un estudiante
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable Long id) {
        estudianteService.deleteEstudiante(id);
        return ResponseEntity.noContent().build(); // Devuelve 204 No Content
    }

    /*Método auxiliar para convertir la entidad Estudiante a un DTO (más seguro para enviar)*/
    private EstudianteDTO convertToDTO(Estudiante estudiante) {
        return new EstudianteDTO(
                estudiante.getId(),
                estudiante.getNombre(),
                estudiante.getGrupo() != null ? estudiante.getGrupo().getId() : null
        );
    }
}








