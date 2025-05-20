package com.example.appStudents.service;

import com.example.appStudents.dto.AsignaturaDTO;
import com.example.appStudents.model.Asignatura;
import com.example.appStudents.model.Grupo;
import com.example.appStudents.model.Maestro;
import com.example.appStudents.repository.AsignaturaRepository;
import com.example.appStudents.repository.GrupoRepository;
import com.example.appStudents.repository.MaestroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaService {

    private final AsignaturaRepository asignaturaRepository;
    private final MaestroRepository maestroRepository;
    private final GrupoRepository grupoRepository;

    public AsignaturaService(AsignaturaRepository asignaturaRepository,
                             MaestroRepository maestroRepository,
                             GrupoRepository grupoRepository) {
        this.asignaturaRepository = asignaturaRepository;
        this.maestroRepository = maestroRepository;
        this.grupoRepository = grupoRepository;
    }

    //Crear o actualizar asignatura
    public Asignatura saveAsignatura(AsignaturaDTO dto) {
        Asignatura asignatura = new Asignatura();
        asignatura.setNombre(dto.getNombre());

        // Relacionar con maestro si existe
        Maestro maestro = maestroRepository.findById(dto.getMaestroId()).orElse(null);
        asignatura.setMaestro(maestro);

        // Relacionar con grupo si existe
        Grupo grupo = grupoRepository.findById(dto.getGrupoId()).orElse(null);
        asignatura.setGrupo(grupo);

        return asignaturaRepository.save(asignatura);
    }

    public Asignatura getAsignaturaById(Long id) {
        return asignaturaRepository.findById(id).orElse(null);
    }

    public List<Asignatura> getAllAsignaturas() {
        return asignaturaRepository.findAll();
    }

    public Asignatura updateAsignatura(Long id, AsignaturaDTO dto) {
        return asignaturaRepository.findById(id).map(asignatura -> {
            asignatura.setNombre(dto.getNombre());

            Maestro maestro = maestroRepository.findById(dto.getMaestroId()).orElse(null);
            asignatura.setMaestro(maestro);

            Grupo grupo = grupoRepository.findById(dto.getGrupoId()).orElse(null);
            asignatura.setGrupo(grupo);

            return asignaturaRepository.save(asignatura);
        }).orElse(null);
    }

    public void deleteAsignatura(Long id) {
        asignaturaRepository.deleteById(id);
    }
}




