package com.example.appStudents.controller;

import com.example.appStudents.dto.GrupoDTO;
import com.example.appStudents.model.Grupo;
import com.example.appStudents.service.GrupoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    private final GrupoService grupoService;

    public GrupoController(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    //Crear nuevo grupo
    @PostMapping
    public ResponseEntity<GrupoDTO> addGrupo(@RequestBody GrupoDTO dto) {
        Grupo grupo = grupoService.saveGrupo(dto);
        GrupoDTO respuesta = convertToDTO(grupo);
        return ResponseEntity.ok(respuesta);
    }

    //Obtener todos los grupos
    @GetMapping
    public ResponseEntity<List<GrupoDTO>> getAllGrupos() {
        List<Grupo> grupos = grupoService.getAllGrupos();
        List<GrupoDTO> dtos = new ArrayList<>();

        for (Grupo grupo : grupos) {
            GrupoDTO dto = convertToDTO(grupo);
            dtos.add(dto);
        }

        return ResponseEntity.ok(dtos);
    }

    //Obtener grupo por ID
    @GetMapping("/{id}")
    public ResponseEntity<GrupoDTO> getGrupoById(@PathVariable Long id) {
        Grupo grupo = grupoService.getGrupoById(id);

        if (grupo != null) {
            GrupoDTO dto = convertToDTO(grupo);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Actualizar grupo
    @PutMapping("/{id}")
    public ResponseEntity<GrupoDTO> updateGrupo(@PathVariable Long id, @RequestBody GrupoDTO dto) {
        Grupo actualizado = grupoService.updateGrupo(id, dto);

        if (actualizado != null) {
            GrupoDTO respuesta = convertToDTO(actualizado);
            return ResponseEntity.ok(respuesta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Eliminar grupo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrupo(@PathVariable Long id) {
        grupoService.deleteGrupo(id);
        return ResponseEntity.noContent().build();
    }

    //Convertir entidad Grupo a DTO
    private GrupoDTO convertToDTO(Grupo grupo) {
        GrupoDTO dto = new GrupoDTO();
        dto.setId(grupo.getId());
        dto.setNombre(grupo.getNombre());
        return dto;
    }
}







