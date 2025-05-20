package com.example.appStudents.service;

import com.example.appStudents.dto.AsistenciaDTO;
import com.example.appStudents.model.Asistencia;
import com.example.appStudents.model.Estudiante;
import com.example.appStudents.model.Asignatura;
import com.example.appStudents.repository.AsistenciaRepository;
import com.example.appStudents.repository.EstudianteRepository;
import com.example.appStudents.repository.AsignaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsistenciaService {

    private final AsistenciaRepository asistenciaRepository;
    private final EstudianteRepository estudianteRepository;
    private final AsignaturaRepository asignaturaRepository;

    public AsistenciaService(AsistenciaRepository asistenciaRepository,
                             EstudianteRepository estudianteRepository,
                             AsignaturaRepository asignaturaRepository) {
        this.asistenciaRepository = asistenciaRepository;
        this.estudianteRepository = estudianteRepository;
        this.asignaturaRepository = asignaturaRepository;
    }

    //Guardar o actualizar asistencia
    public Asistencia saveAsistencia(AsistenciaDTO dto) {
        Asistencia asistencia = new Asistencia();
        asistencia.setFecha(dto.getFecha());
        asistencia.setPresente(dto.isPresente());

        Estudiante estudiante = estudianteRepository.findById(dto.getEstudianteId()).orElse(null);
        asistencia.setEstudiante(estudiante);

        Asignatura asignatura = asignaturaRepository.findById(dto.getAsignaturaId()).orElse(null);
        asistencia.setAsignatura(asignatura);

        return asistenciaRepository.save(asistencia);
    }

    public Asistencia getAsistenciaById(Long id) {
        return asistenciaRepository.findById(id).orElse(null);
    }

    public List<Asistencia> getAllAsistencias() {
        return asistenciaRepository.findAll();
    }

    public Asistencia updateAsistencia(Long id, AsistenciaDTO dto) {
        return asistenciaRepository.findById(id).map(asistencia -> {
            asistencia.setFecha(dto.getFecha());
            asistencia.setPresente(dto.isPresente());

            Estudiante estudiante = estudianteRepository.findById(dto.getEstudianteId()).orElse(null);
            asistencia.setEstudiante(estudiante);

            Asignatura asignatura = asignaturaRepository.findById(dto.getAsignaturaId()).orElse(null);
            asistencia.setAsignatura(asignatura);

            return asistenciaRepository.save(asistencia);
        }).orElse(null);
    }

    public void deleteAsistencia(Long id) {
        asistenciaRepository.deleteById(id);
    }
}




