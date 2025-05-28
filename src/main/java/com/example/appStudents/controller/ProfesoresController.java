package com.example.appStudents.controller;

import com.example.appStudents.dto.ProfesoresDTO;
import com.example.appStudents.model.Profesores;
import com.example.appStudents.service.ProfesoresService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/profesores")
public class ProfesoresController {

    private final ProfesoresService profesoresService;

    public ProfesoresController(ProfesoresService profesoresService) {
        this.profesoresService = profesoresService;
    }

    // Crear un nuevo profesor
    @PostMapping
    public ResponseEntity<ProfesoresDTO> crear(@RequestBody ProfesoresDTO dto) {
        Profesores nuevo = profesoresService.guardarProfesor(dto);
        return ResponseEntity.ok(convertToDTO(nuevo));
    }

    // Listar todos los profesores
    @GetMapping
    public ResponseEntity<List<ProfesoresDTO>> listar() {
        List<Profesores> lista = profesoresService.obtenerTodos();
        List<ProfesoresDTO> dtos = new ArrayList<>();

        for (Profesores profesor : lista) {
            dtos.add(convertToDTO(profesor));
        }

        return ResponseEntity.ok(dtos);
    }

    // Obtener profesor por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProfesoresDTO> obtenerPorId(@PathVariable Long id) {
        Profesores profesor = profesoresService.obtenerPorId(id);
        return profesor != null ? ResponseEntity.ok(convertToDTO(profesor)) : ResponseEntity.notFound().build();
    }

    // Actualizar profesor por ID
    @PutMapping("/{id}")
    public ResponseEntity<ProfesoresDTO> actualizar(@PathVariable Long id, @RequestBody ProfesoresDTO dto) {
        Profesores actualizado = profesoresService.actualizar(id, dto);
        return actualizado != null ? ResponseEntity.ok(convertToDTO(actualizado)) : ResponseEntity.notFound().build();
    }

    // Eliminar profesor por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        profesoresService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // Convertir entidad Profesores a DTO
    private ProfesoresDTO convertToDTO(Profesores profesor) {
        ProfesoresDTO dto = new ProfesoresDTO();
        dto.setId(profesor.getId());
        dto.setNombre(profesor.getNombre());

        if (profesor.getUsuario() != null) {
            dto.setUsuarioId(profesor.getUsuario().getId());
        }

        if (profesor.getCursos() != null) {
            List<Long> cursoIds = profesor.getCursos().stream().map(c -> c.getId()).toList();
            dto.setCursoIds(cursoIds);
        }

        if (profesor.getAsignaturas() != null) {
            List<Long> asignaturaIds = profesor.getAsignaturas().stream().map(a -> a.getId()).toList();
            dto.setAsignaturaIds(asignaturaIds);
        }

        if (profesor.getEstudiantes() != null) {
            List<Long> estudianteIds = profesor.getEstudiantes().stream().map(e -> e.getId()).toList();
            dto.setEstudianteIds(estudianteIds);
        }

        return dto;
    }
}







