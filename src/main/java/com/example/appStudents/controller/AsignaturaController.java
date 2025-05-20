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

    //Crear nueva asignatura
    @PostMapping
    public ResponseEntity<AsignaturaDTO> addAsignatura(@RequestBody AsignaturaDTO dto) {
        Asignatura asignatura = asignaturaService.saveAsignatura(dto);
        return ResponseEntity.ok(convertToDTO(asignatura));
    }

    //Obtener todas las asignaturas
    @GetMapping
    public ResponseEntity<List<AsignaturaDTO>> getAllAsignaturas() {
        List<Asignatura> asignaturas = asignaturaService.getAllAsignaturas();
        List<AsignaturaDTO> dtos = new ArrayList<>();

        for (Asignatura asignatura : asignaturas) {
            AsignaturaDTO dto = convertToDTO(asignatura);
            dtos.add(dto);
        }

        return ResponseEntity.ok(dtos);
    }

    //Obtener asignatura por ID
    @GetMapping("/{id}")
    public ResponseEntity<AsignaturaDTO> getAsignaturaById(@PathVariable Long id) {
        Asignatura asignatura = asignaturaService.getAsignaturaById(id);

        if (asignatura != null) {
            AsignaturaDTO dto = convertToDTO(asignatura);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Actualizar asignatura
    @PutMapping("/{id}")
    public ResponseEntity<AsignaturaDTO> updateAsignatura(@PathVariable Long id, @RequestBody AsignaturaDTO dto) {
        Asignatura updated = asignaturaService.updateAsignatura(id, dto);

        if (updated != null) {
            AsignaturaDTO actualizado = convertToDTO(updated);
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Eliminar asignatura
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsignatura(@PathVariable Long id) {
        asignaturaService.deleteAsignatura(id);
        return ResponseEntity.noContent().build();
    }

    //Método auxiliar para convertir Asignatura a DTO
    private AsignaturaDTO convertToDTO(Asignatura asignatura) {
        AsignaturaDTO dto = new AsignaturaDTO();
        dto.setId(asignatura.getId());
        dto.setNombre(asignatura.getNombre());

        if (asignatura.getMaestro() != null) {
            dto.setMaestroId(asignatura.getMaestro().getId());
        }

        if (asignatura.getGrupo() != null) {
            dto.setGrupoId(asignatura.getGrupo().getId());
        }

        return dto;
    }
}








