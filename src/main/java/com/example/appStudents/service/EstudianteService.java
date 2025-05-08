package com.example.appStudents.service;

import com.example.appStudents.model.Estudiante;
import com.example.appStudents.model.Maestro;
import com.example.appStudents.repository.EstudianteRepository;
import com.example.appStudents.repository.MaestroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository){
        this.estudianteRepository = estudianteRepository;
    }

    //Guardar estudiante
    public Estudiante saveEstudiante (Estudiante estudiante){
    return estudianteRepository.save(estudiante);
    }

    //Listar estudiantes
    public List<Estudiante> getAllEstudiantes(){
    return estudianteRepository.findAll();
    }

    // Obtener estudiantes por id
    public Optional<Estudiante> getEstudianteId(Long id){
    return estudianteRepository.findById(id);
    }

    // Actualizar estudiante
    public Estudiante updateEstudiante(Long id, Estudiante estudiante){
    if (estudianteRepository.existsById(id)){
        estudiante.setId(id);
        return estudianteRepository.save(estudiante);
    }
    return null;
    }

    //Borrar estudiante con id
    public void deleteEstudiante(Long id){
        estudianteRepository.deleteById(id);
    }
//
//    // Guarda un estudiante nuevo y lo asocia a un maestro existente
//    public Estudiante guardar(Estudiante estudiante, Long idMaestro) {
//        Maestro maestro = maestroRepo.findById(idMaestro).orElseThrow();
//        estudiante.setMaestro(maestro);
//        return estudianteRepo.save(estudiante);
//    }
}



