package com.example.appStudents.service;

import com.example.appStudents.model.Maestro;
import com.example.appStudents.repository.MaestroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaestroService {

    private final MaestroRepository maestroRepository;

    public MaestroService(MaestroRepository maestroRepository) {
        this.maestroRepository = maestroRepository;
    }

    //Guardar un nuevo maestro
    public Maestro guardarMaestro(Maestro maestro) {
        return maestroRepository.save(maestro);
    }

    //Obtener todos los maestros
    public List<Maestro> obtenerTodosMaestros() {
        return maestroRepository.findAll();
    }

    //Obtener un maestro por ID
    public Maestro obtenerEntidadPorId(Long id) {
        return maestroRepository.findById(id).orElse(null);
    }

    //Actualizar un maestro existente
    public Maestro actualizarMaestro(Maestro maestro) {
        return maestroRepository.save(maestro); // Spring lo actualiza si el ID ya existe
    }

    //Eliminar un maestro por ID
    public void eliminarMaestro(Long id) {
        maestroRepository.deleteById(id);
    }
}







