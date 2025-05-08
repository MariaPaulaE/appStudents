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
public class MaestroService {

    @Autowired
    private MaestroRepository maestroRepository;

    public MaestroService(MaestroRepository maestroRepository){
        this.maestroRepository = maestroRepository;
    }

    //Guardar maestro
    public Maestro saveMaestro (Maestro maestro){
        return maestroRepository.save(maestro);
    }

    //Listar maestro
    public List<Maestro> getAllMaestros(){
        return maestroRepository.findAll();
    }

    // Obtener maestro por id
    public Optional<Maestro> getMaestroId(Long id){
        return maestroRepository.findById(id);
    }

    // Actualizar maestro
    public Maestro updateMaestro(Long id, Maestro maestro){
        if (maestroRepository.existsById(id)){
            maestro.setId(id);
            return maestroRepository.save(maestro);
        }
        return null;
    }

    //Borrar maestro con id
    public void deleteMaestro(Long id){
        maestroRepository.deleteById(id);
    }
}


