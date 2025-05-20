package com.example.appStudents.controller;

import com.example.appStudents.dto.MaestroDTO;
import com.example.appStudents.model.Maestro;
import com.example.appStudents.service.MaestroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/maestros")
public class MaestroController {

    private final MaestroService maestroService;

    public MaestroController(MaestroService maestroService) {
        this.maestroService = maestroService;
    }

    //Crear nuevo maestro
    @PostMapping
    public ResponseEntity<MaestroDTO> crearMaestro(@RequestBody Maestro maestro) {
        Maestro guardado = maestroService.guardarMaestro(maestro);
        MaestroDTO dto = convertToDTO(guardado);
        return ResponseEntity.ok(dto);
    }

    //Obtener todos los maestros
    @GetMapping
    public ResponseEntity<List<MaestroDTO>> obtenerMaestros() {
        List<Maestro> maestros = maestroService.obtenerTodosMaestros();
        List<MaestroDTO> dtos = new ArrayList<>();

        for (Maestro maestro : maestros) {
            MaestroDTO dto = convertToDTO(maestro);
            dtos.add(dto);
        }

        return ResponseEntity.ok(dtos);
    }

    //Obtener maestro por ID
    @GetMapping("/{id}")
    public ResponseEntity<MaestroDTO> obtenerPorId(@PathVariable Long id) {
        Maestro maestro = maestroService.obtenerEntidadPorId(id);

        if (maestro != null) {
            MaestroDTO dto = convertToDTO(maestro);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Actualizar maestro
    @PutMapping("/{id}")
    public ResponseEntity<MaestroDTO> actualizar(@PathVariable Long id, @RequestBody Maestro maestro) {
        maestro.setId(id);
        Maestro actualizado = maestroService.actualizarMaestro(maestro);
        MaestroDTO dto = convertToDTO(actualizado);
        return ResponseEntity.ok(dto);
    }

    //Eliminar maestro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        maestroService.eliminarMaestro(id);
        return ResponseEntity.noContent().build();
    }

    //Convertir entidad a DTO
    private MaestroDTO convertToDTO(Maestro maestro) {
        MaestroDTO dto = new MaestroDTO();
        dto.setId(maestro.getId());
        dto.setNombre(maestro.getNombre());
        return dto;
    }
}





