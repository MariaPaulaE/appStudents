package com.example.appStudents.controller;

import com.example.appStudents.model.Estudiante;
import com.example.appStudents.model.Maestro;
import com.example.appStudents.service.EstudianteService;
import com.example.appStudents.service.MaestroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/maestro")
public class MaestroController {

    @Autowired
    private MaestroService maestroService;

    @PostMapping
    public Maestro addMaestro(@RequestBody Maestro maestro){
        return maestroService.saveMaestro(maestro);
    }

    @GetMapping
    public List<Maestro> getMaestroAll(){
        return maestroService.getAllMaestros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maestro> getMaestroId(@PathVariable Long id){
        Optional<Maestro> maestro = maestroService.getMaestroId(id);
        return maestro.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Maestro updateMaestroId(@PathVariable Long id, @RequestBody Maestro maestro){
        return maestroService.updateMaestro(id, maestro);
    }

    @DeleteMapping("{id}")
    public void deleteMaestro(@PathVariable Long id){
        maestroService.deleteMaestro(id);
    }
}

