package com.example.appStudents.controller;

import com.example.appStudents.model.Maestro;
import com.example.appStudents.service.MaestroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maestros")
public class MaestroController {

    private final MaestroService service;

    public MaestroController(MaestroService service) {
        this.service = service;
    }

    @GetMapping
    public List<Maestro> listar() {
        return service.listar();
    }

    @PostMapping
    public Maestro guardar(@RequestBody Maestro maestro) {
        return service.guardar(maestro);
    }

    @GetMapping("/{id}")
    public Maestro obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }
}

