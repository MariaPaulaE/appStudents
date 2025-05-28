package com.example.appStudents.controller;

import com.example.appStudents.dto.AsistenciaDTO;
import com.example.appStudents.model.Asistencia;
import com.example.appStudents.service.AsistenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/asistencias")
public class AsistenciaController {

    private final AsistenciaService asistenciaService;

    public AsistenciaController(AsistenciaService asistenciaService) {
        this.asistenciaService = asistenciaService;
    }

    // Crear una nueva asistencia
    @PostMapping
    public ResponseEntity<AsistenciaDTO> crear(@RequestBody AsistenciaDTO dto) {
        Asistencia nueva = asistenciaService.guardarAsistencia(dto);
        return ResponseEntity.ok(convertToDTO(nueva));
    }

    // Listar todas las asistencias
    @GetMapping
    public ResponseEntity<List<AsistenciaDTO>> listar() {
        List<Asistencia> lista = asistenciaService.obtenerTodas();
        List<AsistenciaDTO> dtos = new ArrayList<>();

        for (Asistencia asistencia : lista) {
            dtos.add(convertToDTO(asistencia));
        }

        return ResponseEntity.ok(dtos);
    }

    // Obtener una asistencia por su ID
    @GetMapping("/{id}")
    public ResponseEntity<AsistenciaDTO> obtenerPorId(@PathVariable Long id) {
        Asistencia asistencia = asistenciaService.obtenerPorId(id);
        return asistencia != null ? ResponseEntity.ok(convertToDTO(asistencia)) : ResponseEntity.notFound().build();
    }

    // Actualizar una asistencia existente
    @PutMapping("/{id}")
    public ResponseEntity<AsistenciaDTO> actualizar(@PathVariable Long id, @RequestBody AsistenciaDTO dto) {
        Asistencia actualizada = asistenciaService.actualizar(id, dto);
        return actualizada != null ? ResponseEntity.ok(convertToDTO(actualizada)) : ResponseEntity.notFound().build();
    }

    // Eliminar una asistencia por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        asistenciaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // Convertir entidad Asistencia a DTO
    private AsistenciaDTO convertToDTO(Asistencia asistencia) {
        AsistenciaDTO dto = new AsistenciaDTO();
        dto.setId(asistencia.getId());
        dto.setFecha(asistencia.getFecha());
        dto.setEstado(asistencia.getEstado());

        if (asistencia.getEstudiante() != null) {
            dto.setEstudianteId(asistencia.getEstudiante().getId());
        }

        if (asistencia.getAsignatura() != null) {
            dto.setAsignaturaId(asistencia.getAsignatura().getId());
        }

        return dto;
    }
}







