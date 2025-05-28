package com.example.appStudents.service;

import com.example.appStudents.dto.EstudiantesDTO;
import com.example.appStudents.model.Curso;
import com.example.appStudents.model.Estudiantes;
import com.example.appStudents.repository.CursoRepository;
import com.example.appStudents.repository.EstudiantesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudiantesService {

    private final EstudiantesRepository estudiantesRepository;
    private final CursoRepository cursoRepository;

    // Constructor para inyectar los repositorios
    public EstudiantesService(EstudiantesRepository estudiantesRepository, CursoRepository cursoRepository) {
        this.estudiantesRepository = estudiantesRepository;
        this.cursoRepository = cursoRepository;
    }

    // Método para guardar un nuevo estudiante usando un DTO
    public Estudiantes guardarEstudiante(EstudiantesDTO dto) {
        Estudiantes estudiante = new Estudiantes();

        // Se copian los campos del DTO al modelo
        estudiante.setIdEstudiante(dto.getIdEstudiante());
        estudiante.setNombre(dto.getNombre());
        estudiante.setApellido(dto.getApellido());
        estudiante.setFechaNacimiento(dto.getFechaNacimiento());
        estudiante.setGenero(dto.getGenero());
        estudiante.setGrado(dto.getGrado());
        estudiante.setDireccion(dto.getDireccion());
        estudiante.setTelefono(dto.getTelefono());
        estudiante.setEmail(dto.getEmail());
        estudiante.setFechaIngreso(dto.getFechaIngreso());

        // Si se envió un cursoId, se busca el curso y se asigna
        if (dto.getCursoId() != null) {
            Curso curso = cursoRepository.findById(dto.getCursoId()).orElse(null);
            estudiante.setCurso(curso);
        }

        return estudiantesRepository.save(estudiante);
    }

    // Método para obtener todos los estudiantes
    public List<Estudiantes> obtenerTodos() {
        return estudiantesRepository.findAll();
    }

    // Método para obtener un estudiante por ID
    public Estudiantes obtenerPorId(Long id) {
        return estudiantesRepository.findById(id).orElse(null);
    }

    // Método para actualizar un estudiante existente
    public Estudiantes actualizar(Long id, EstudiantesDTO dto) {
        return estudiantesRepository.findById(id).map(estudiante -> {
            // Actualiza los campos con los valores del DTO
            estudiante.setIdEstudiante(dto.getIdEstudiante());
            estudiante.setNombre(dto.getNombre());
            estudiante.setApellido(dto.getApellido());
            estudiante.setFechaNacimiento(dto.getFechaNacimiento());
            estudiante.setGenero(dto.getGenero());
            estudiante.setGrado(dto.getGrado());
            estudiante.setDireccion(dto.getDireccion());
            estudiante.setTelefono(dto.getTelefono());
            estudiante.setEmail(dto.getEmail());
            estudiante.setFechaIngreso(dto.getFechaIngreso());

            // Si se envió un cursoId, se actualiza la relación con Curso
            if (dto.getCursoId() != null) {
                Curso curso = cursoRepository.findById(dto.getCursoId()).orElse(null);
                estudiante.setCurso(curso);
            }

            return estudiantesRepository.save(estudiante);
        }).orElse(null);
    }

    // Método para eliminar un estudiante por ID
    public void eliminar(Long id) {
        estudiantesRepository.deleteById(id);
    }
}


