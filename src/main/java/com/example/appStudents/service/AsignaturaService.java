package com.example.appStudents.service;

import com.example.appStudents.dto.AsignaturaDTO;
import com.example.appStudents.model.Asignatura;
import com.example.appStudents.model.Curso;
import com.example.appStudents.model.Profesores;
import com.example.appStudents.repository.AsignaturaRepository;
import com.example.appStudents.repository.CursoRepository;
import com.example.appStudents.repository.ProfesoresRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaService {

    private final AsignaturaRepository asignaturaRepository;
    private final ProfesoresRepository profesoresRepository;
    private final CursoRepository cursoRepository;

    public AsignaturaService(AsignaturaRepository asignaturaRepository,
                             ProfesoresRepository profesoresRepository,
                             CursoRepository cursoRepository) {
        this.asignaturaRepository = asignaturaRepository;
        this.profesoresRepository = profesoresRepository;
        this.cursoRepository = cursoRepository;
    }

    // Guardar una nueva asignatura desde un DTO
    public Asignatura guardarAsignatura(AsignaturaDTO dto) {
        Asignatura asignatura = new Asignatura();
        asignatura.setNombre(dto.getNombre());

        if (dto.getProfesorId() != null) {
            Profesores profesor = profesoresRepository.findById(dto.getProfesorId()).orElse(null);
            asignatura.setProfesor(profesor);
        }

        if (dto.getCursoId() != null) {
            Curso curso = cursoRepository.findById(dto.getCursoId()).orElse(null);
            asignatura.setCurso(curso);
        }

        return asignaturaRepository.save(asignatura);
    }

    // Obtener todas las asignaturas
    public List<Asignatura> obtenerTodas() {
        return asignaturaRepository.findAll();
    }

    // Obtener asignatura por ID
    public Asignatura obtenerPorId(Long id) {
        return asignaturaRepository.findById(id).orElse(null);
    }

    // Actualizar una asignatura existente
    public Asignatura actualizar(Long id, AsignaturaDTO dto) {
        return asignaturaRepository.findById(id).map(asignatura -> {
            asignatura.setNombre(dto.getNombre());

            if (dto.getProfesorId() != null) {
                Profesores profesor = profesoresRepository.findById(dto.getProfesorId()).orElse(null);
                asignatura.setProfesor(profesor);
            }

            if (dto.getCursoId() != null) {
                Curso curso = cursoRepository.findById(dto.getCursoId()).orElse(null);
                asignatura.setCurso(curso);
            }

            return asignaturaRepository.save(asignatura);
        }).orElse(null);
    }

    // Eliminar una asignatura por ID
    public void eliminar(Long id) {
        asignaturaRepository.deleteById(id);
    }
}





