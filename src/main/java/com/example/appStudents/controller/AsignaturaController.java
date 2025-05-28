package com.example.appStudents.controller;

import com.example.appStudents.dto.AsignaturaDTO;
import com.example.appStudents.model.Asignatura;
import com.example.appStudents.service.AsignaturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/asignaturas")
public class AsignaturaController {

    private final AsignaturaService asignaturaService;

    public AsignaturaController(AsignaturaService asignaturaService) {
        this.asignaturaService = asignaturaService;
    }

    // Crear una nueva asignatura
    @PostMapping
    public ResponseEntity<AsignaturaDTO> crear(@RequestBody AsignaturaDTO dto) {
        Asignatura nueva = asignaturaService.guardarAsignatura(dto);
        return ResponseEntity.ok(convertToDTO(nueva));
    }

    // Obtener todas las asignaturas
    @GetMapping
    public ResponseEntity<List<AsignaturaDTO>> listar() {
        List<Asignatura> lista = asignaturaService.obtenerTodas();
        List<AsignaturaDTO> dtos = new ArrayList<>();

        for (Asignatura asignatura : lista) {
            dtos.add(convertToDTO(asignatura));
        }

        return ResponseEntity.ok(dtos);
    }

    // Obtener una asignatura por su ID
    @GetMapping("/{id}")
    public ResponseEntity<AsignaturaDTO> obtenerPorId(@PathVariable Long id) {
        Asignatura asignatura = asignaturaService.obtenerPorId(id);
        return asignatura != null ? ResponseEntity.ok(convertToDTO(asignatura)) : ResponseEntity.notFound().build();
    }

    // Actualizar una asignatura existente
    @PutMapping("/{id}")
    public ResponseEntity<AsignaturaDTO> actualizar(@PathVariable Long id, @RequestBody AsignaturaDTO dto) {
        Asignatura actualizada = asignaturaService.actualizar(id, dto);
        return actualizada != null ? ResponseEntity.ok(convertToDTO(actualizada)) : ResponseEntity.notFound().build();
    }

    // Eliminar una asignatura por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        asignaturaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // Convertir una entidad Asignatura a DTO
    private AsignaturaDTO convertToDTO(Asignatura asignatura) {
        AsignaturaDTO dto = new AsignaturaDTO();
        dto.setId(asignatura.getId());
        dto.setNombre(asignatura.getNombre());

        if (asignatura.getProfesor() != null) {
            dto.setProfesorId(asignatura.getProfesor().getId());
        }

        if (asignatura.getCurso() != null) {
            dto.setCursoId(asignatura.getCurso().getId());
        }

        return dto;
    }
}









