package com.example.appStudents.service;

import com.example.appStudents.dto.GrupoDTO;
import com.example.appStudents.model.Grupo;
import com.example.appStudents.repository.GrupoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Clase marcada como servicio, contiene la lógica de negocio
public class GrupoService {

    private final GrupoRepository grupoRepository;

    // Inyectamos el repositorio por constructor
    public GrupoService(GrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    //Crear o actualizar un grupo
    public Grupo saveGrupo(GrupoDTO dto) {
        Grupo grupo = new Grupo();
        grupo.setNombre(dto.getNombre()); // Asigna el nombre recibido desde el DTO
        return grupoRepository.save(grupo); // Guarda o actualiza en la base de datos
    }

    //Obtener un grupo por ID
    public Grupo getGrupoById(Long id) {
        return grupoRepository.findById(id).orElse(null);
    }

    //Obtener todos los grupos registrados
    public List<Grupo> getAllGrupos() {
        return grupoRepository.findAll();
    }

    //Actualizar un grupo existente
    public Grupo updateGrupo(Long id, GrupoDTO dto) {
        return grupoRepository.findById(id).map(grupo -> {
            grupo.setNombre(dto.getNombre()); // Cambia el nombre del grupo
            return grupoRepository.save(grupo);
        }).orElse(null); // Si no se encuentra el grupo, devuelve null
    }

    //Eliminar un grupo por su ID
    public void deleteGrupo(Long id) {
        grupoRepository.deleteById(id);
    }
}







