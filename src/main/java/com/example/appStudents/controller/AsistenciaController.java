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

    //Crear nueva asistencia
    @PostMapping
    public ResponseEntity<AsistenciaDTO> addAsistencia(@RequestBody AsistenciaDTO dto) {
        Asistencia asistencia = asistenciaService.saveAsistencia(dto);
        AsistenciaDTO respuesta = convertToDTO(asistencia);
        return ResponseEntity.ok(respuesta);
    }

    //Obtener todas las asistencias
    @GetMapping
    public ResponseEntity<List<AsistenciaDTO>> getAllAsistencias() {
        List<Asistencia> asistencias = asistenciaService.getAllAsistencias();
        List<AsistenciaDTO> dtos = new ArrayList<>();

        for (Asistencia asistencia : asistencias) {
            AsistenciaDTO dto = convertToDTO(asistencia);
            dtos.add(dto);
        }

        return ResponseEntity.ok(dtos);
    }

    //Obtener asistencia por ID
    @GetMapping("/{id}")
    public ResponseEntity<AsistenciaDTO> getAsistenciaById(@PathVariable Long id) {
        Asistencia asistencia = asistenciaService.getAsistenciaById(id);

        if (asistencia != null) {
            AsistenciaDTO dto = convertToDTO(asistencia);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Actualizar asistencia
    @PutMapping("/{id}")
    public ResponseEntity<AsistenciaDTO> updateAsistencia(@PathVariable Long id, @RequestBody AsistenciaDTO dto) {
        Asistencia updated = asistenciaService.updateAsistencia(id, dto);

        if (updated != null) {
            AsistenciaDTO respuesta = convertToDTO(updated);
            return ResponseEntity.ok(respuesta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Eliminar asistencia
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsistencia(@PathVariable Long id) {
        asistenciaService.deleteAsistencia(id);
        return ResponseEntity.noContent().build();
    }

    //Convertir Asistencia (entidad) a DTO
    private AsistenciaDTO convertToDTO(Asistencia asistencia) {
        AsistenciaDTO dto = new AsistenciaDTO();
        dto.setId(asistencia.getId());
        dto.setFecha(asistencia.getFecha());
        dto.setPresente(asistencia.isPresente());

        if (asistencia.getEstudiante() != null) {
            dto.setEstudianteId(asistencia.getEstudiante().getId());
        }

        if (asistencia.getAsignatura() != null) {
            dto.setAsignaturaId(asistencia.getAsignatura().getId());
        }

        return dto;
    }
}






