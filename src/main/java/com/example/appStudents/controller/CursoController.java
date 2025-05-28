package com.example.appStudents.controller;

import com.example.appStudents.dto.CursoDTO;
import com.example.appStudents.model.Curso;
import com.example.appStudents.service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public ResponseEntity<CursoDTO> crear(@RequestBody CursoDTO dto) {
        Curso nuevo = cursoService.guardarCurso(dto);
        return ResponseEntity.ok(convertToDTO(nuevo));
    }

    @GetMapping
    public ResponseEntity<List<CursoDTO>> listar() {
        List<Curso> lista = cursoService.obtenerTodos();
        List<CursoDTO> dtos = new ArrayList<>();

        for (Curso curso : lista) {
            dtos.add(convertToDTO(curso));
        }

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> obtenerPorId(@PathVariable Long id) {
        Curso curso = cursoService.obtenerPorId(id);
        return curso != null ? ResponseEntity.ok(convertToDTO(curso)) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> actualizar(@PathVariable Long id, @RequestBody CursoDTO dto) {
        Curso actualizado = cursoService.actualizar(id, dto);
        return actualizado != null ? ResponseEntity.ok(convertToDTO(actualizado)) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        cursoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    private CursoDTO convertToDTO(Curso curso) {
        CursoDTO dto = new CursoDTO();
        dto.setId(curso.getId());
        dto.setNombre(curso.getNombre());
        return dto;
    }
}







