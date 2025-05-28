package com.example.appStudents.service;

import com.example.appStudents.dto.AsistenciaDTO;
import com.example.appStudents.model.Asignatura;
import com.example.appStudents.model.Asistencia;
import com.example.appStudents.model.Estudiantes;
import com.example.appStudents.repository.AsignaturaRepository;
import com.example.appStudents.repository.AsistenciaRepository;
import com.example.appStudents.repository.EstudiantesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsistenciaService {

    private final AsistenciaRepository asistenciaRepository;
    private final EstudiantesRepository estudiantesRepository;
    private final AsignaturaRepository asignaturaRepository;

    public AsistenciaService(AsistenciaRepository asistenciaRepository,
                             EstudiantesRepository estudiantesRepository,
                             AsignaturaRepository asignaturaRepository) {
        this.asistenciaRepository = asistenciaRepository;
        this.estudiantesRepository = estudiantesRepository;
        this.asignaturaRepository = asignaturaRepository;
    }

    // Guardar una nueva asistencia desde un DTO
    public Asistencia guardarAsistencia(AsistenciaDTO dto) {
        Asistencia asistencia = new Asistencia();

        asistencia.setFecha(dto.getFecha());
        asistencia.setEstado(dto.getEstado());

        if (dto.getEstudianteId() != null) {
            Estudiantes estudiante = estudiantesRepository.findById(dto.getEstudianteId()).orElse(null);
            asistencia.setEstudiante(estudiante);
        }

        if (dto.getAsignaturaId() != null) {
            Asignatura asignatura = asignaturaRepository.findById(dto.getAsignaturaId()).orElse(null);
            asistencia.setAsignatura(asignatura);
        }

        return asistenciaRepository.save(asistencia);
    }

    // Obtener todas las asistencias
    public List<Asistencia> obtenerTodas() {
        return asistenciaRepository.findAll();
    }

    // Obtener asistencia por ID
    public Asistencia obtenerPorId(Long id) {
        return asistenciaRepository.findById(id).orElse(null);
    }

    // Actualizar una asistencia existente
    public Asistencia actualizar(Long id, AsistenciaDTO dto) {
        return asistenciaRepository.findById(id).map(asistencia -> {
            asistencia.setFecha(dto.getFecha());
            asistencia.setEstado(dto.getEstado());

            if (dto.getEstudianteId() != null) {
                Estudiantes estudiante = estudiantesRepository.findById(dto.getEstudianteId()).orElse(null);
                asistencia.setEstudiante(estudiante);
            }

            if (dto.getAsignaturaId() != null) {
                Asignatura asignatura = asignaturaRepository.findById(dto.getAsignaturaId()).orElse(null);
                asistencia.setAsignatura(asignatura);
            }

            return asistenciaRepository.save(asistencia);
        }).orElse(null);
    }

    // Eliminar una asistencia por ID
    public void eliminar(Long id) {
        asistenciaRepository.deleteById(id);
    }
}





