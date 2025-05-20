package com.example.appStudents.service;

import com.example.appStudents.model.Estudiante;
import com.example.appStudents.model.Grupo;
import com.example.appStudents.repository.EstudianteRepository;
import com.example.appStudents.repository.GrupoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service // Indica que esta clase es un servicio que puede ser inyectado en otras partes
public class EstudianteService {

    // Repositorios para acceder a la base de datos
    private final EstudianteRepository estudianteRepository;
    private final GrupoRepository grupoRepository;

    // Constructor para inyectar los repositorios
    public EstudianteService(EstudianteRepository estudianteRepository,
                             GrupoRepository grupoRepository) {
        this.estudianteRepository = estudianteRepository;
        this.grupoRepository = grupoRepository;
    }

    //Obtener todos los estudiantes desde la base de datos
    public List<Estudiante> getAllEstudiantes() {
        return estudianteRepository.findAll();
    }

    //Buscar un estudiante por su ID
    public Optional<Estudiante> getEstudianteById(Long id) {
        return estudianteRepository.findById(id);
    }

    //Guardar un nuevo estudiante
    @Transactional
    public Estudiante saveEstudiante(String nombre, Long grupoId) {
        Estudiante estudiante = new Estudiante(nombre); // Crea un nuevo estudiante con nombre

        // Si el grupoId no es nulo, se busca ese grupo
        if (grupoId != null) {
            Grupo grupo = grupoRepository.findById(grupoId)
                    .orElseThrow(() -> new RuntimeException("Grupo no encontrado con ID: " + grupoId));
            estudiante.setGrupo(grupo); // Asigna el grupo al estudiante
        }

        return estudianteRepository.save(estudiante); // Guarda el estudiante en la base de datos
    }

    //Actualizar un estudiante existente
    @Transactional
    public Estudiante updateEstudiante(Long id, String nombre, Long grupoId) {
        return estudianteRepository.findById(id)
                .map(estudiante -> {
                    estudiante.setNombre(nombre); // Cambia el nombre

                    if (grupoId != null) {
                        // Si se envía un grupo, lo busca y lo asigna
                        Grupo grupo = grupoRepository.findById(grupoId)
                                .orElseThrow(() -> new RuntimeException("Grupo no encontrado"));
                        estudiante.setGrupo(grupo);
                    } else {
                        // Si no se envía grupo, se elimina la relación
                        estudiante.setGrupo(null);
                    }

                    return estudianteRepository.save(estudiante); // Guarda los cambios
                })
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }

    //Eliminar estudiante por su ID
    @Transactional
    public void deleteEstudiante(Long id) {
        if (!estudianteRepository.existsById(id)) {
            throw new RuntimeException("Estudiante no encontrado");
        }

        estudianteRepository.deleteById(id); // Borra el estudiante
    }
}



