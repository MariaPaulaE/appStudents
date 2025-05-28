package com.example.appStudents.service;

import com.example.appStudents.dto.ProfesoresDTO;
import com.example.appStudents.model.*;
import com.example.appStudents.repository.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfesoresService {

    private final ProfesoresRepository profesoresRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;
    private final AsignaturaRepository asignaturaRepository;
    private final EstudiantesRepository estudiantesRepository;

    public ProfesoresService(
            ProfesoresRepository profesoresRepository,
            UsuarioRepository usuarioRepository,
            CursoRepository cursoRepository,
            AsignaturaRepository asignaturaRepository,
            EstudiantesRepository estudiantesRepository
    ) {
        this.profesoresRepository = profesoresRepository;
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
        this.asignaturaRepository = asignaturaRepository;
        this.estudiantesRepository = estudiantesRepository;
    }

    // Guardar un nuevo profesor desde un DTO
    public Profesores guardarProfesor(ProfesoresDTO dto) {
        Profesores profesor = new Profesores();
        profesor.setNombre(dto.getNombre());

        // Asignar usuario
        if (dto.getUsuarioId() != null) {
            Usuario usuario = usuarioRepository.findById(dto.getUsuarioId()).orElse(null);
            profesor.setUsuario(usuario);
        }

        // Asignar cursos
        if (dto.getCursoIds() != null) {
            List<Curso> cursos = cursoRepository.findAllById(dto.getCursoIds());
            profesor.setCursos(cursos);
        }

        // Asignar asignaturas
        if (dto.getAsignaturaIds() != null) {
            List<Asignatura> asignaturas = asignaturaRepository.findAllById(dto.getAsignaturaIds());
            profesor.setAsignaturas(asignaturas);
        }

        // Asignar estudiantes
        if (dto.getEstudianteIds() != null) {
            List<Estudiantes> estudiantes = estudiantesRepository.findAllById(dto.getEstudianteIds());
            profesor.setEstudiantes(estudiantes);
        }

        return profesoresRepository.save(profesor);
    }

    // Obtener todos los profesores
    public List<Profesores> obtenerTodos() {
        return profesoresRepository.findAll();
    }

    // Obtener un profesor por ID
    public Profesores obtenerPorId(Long id) {
        return profesoresRepository.findById(id).orElse(null);
    }

    // Actualizar un profesor existente
    public Profesores actualizar(Long id, ProfesoresDTO dto) {
        return profesoresRepository.findById(id).map(profesor -> {
            profesor.setNombre(dto.getNombre());

            if (dto.getUsuarioId() != null) {
                Usuario usuario = usuarioRepository.findById(dto.getUsuarioId()).orElse(null);
                profesor.setUsuario(usuario);
            }

            if (dto.getCursoIds() != null) {
                List<Curso> cursos = cursoRepository.findAllById(dto.getCursoIds());
                profesor.setCursos(cursos);
            }

            if (dto.getAsignaturaIds() != null) {
                List<Asignatura> asignaturas = asignaturaRepository.findAllById(dto.getAsignaturaIds());
                profesor.setAsignaturas(asignaturas);
            }

            if (dto.getEstudianteIds() != null) {
                List<Estudiantes> estudiantes = estudiantesRepository.findAllById(dto.getEstudianteIds());
                profesor.setEstudiantes(estudiantes);
            }

            return profesoresRepository.save(profesor);
        }).orElse(null);
    }

    // Eliminar un profesor por ID
    public void eliminar(Long id) {
        profesoresRepository.deleteById(id);
    }
}









