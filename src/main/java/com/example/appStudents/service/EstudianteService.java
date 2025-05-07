package com.example.appStudents.service;

import com.example.appStudents.model.Estudiante;
import com.example.appStudents.model.Maestro;
import com.example.appStudents.repository.EstudianteRepository;
import com.example.appStudents.repository.MaestroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepo;
    private final MaestroRepository maestroRepo;

    public EstudianteService(EstudianteRepository estudianteRepo, MaestroRepository maestroRepo) {
        this.estudianteRepo = estudianteRepo;
        this.maestroRepo = maestroRepo;
    }

    // Lista todos los estudiantes
    public List<Estudiante> listar() {
        return estudianteRepo.findAll();
    }

    // Guarda un estudiante nuevo y lo asocia a un maestro existente
    public Estudiante guardar(Estudiante estudiante, Long idMaestro) {
        Maestro maestro = maestroRepo.findById(idMaestro).orElseThrow();
        estudiante.setMaestro(maestro);
        return estudianteRepo.save(estudiante);
    }

    // Elimina un estudiante por ID
    public void eliminar(Long id) {
        estudianteRepo.deleteById(id);
    }
}



