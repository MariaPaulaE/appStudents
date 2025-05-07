package com.example.appStudents.service;

import com.example.appStudents.model.Maestro;
import com.example.appStudents.repository.MaestroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaestroService {

    private final MaestroRepository repository;

    public MaestroService(MaestroRepository repository) {
        this.repository = repository;
    }

    // Guarda un nuevo maestro en la base de datos
    public Maestro guardar(Maestro maestro) {
        return repository.save(maestro);
    }

    // Elimina un maestro por su ID
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    // Devuelve la lista de todos los maestros
    public List<Maestro> listar() {
        return repository.findAll();
    }

    // Busca y devuelve un maestro por su ID
    public Maestro obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
}


