package com.example.appStudents.service;

import com.example.appStudents.dto.CursoDTO;
import com.example.appStudents.model.Curso;
import com.example.appStudents.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    // Crear nuevo curso desde DTO
    public Curso guardarCurso(CursoDTO dto) {
        Curso curso = new Curso();
        curso.setNombre(dto.getNombre());
        return cursoRepository.save(curso);
    }

    // Obtener todos los cursos
    public List<Curso> obtenerTodos() {
        return cursoRepository.findAll();
    }

    // Obtener curso por ID
    public Curso obtenerPorId(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    // Actualizar curso existente
    public Curso actualizar(Long id, CursoDTO dto) {
        return cursoRepository.findById(id).map(curso -> {
            curso.setNombre(dto.getNombre());
            return cursoRepository.save(curso);
        }).orElse(null);
    }

    // Eliminar curso por ID
    public void eliminar(Long id) {
        cursoRepository.deleteById(id);
    }
}








