package com.example.appStudents.controller;

import com.example.appStudents.dto.UsuarioDTO;
import com.example.appStudents.model.Usuario;
import com.example.appStudents.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> crear(@RequestBody UsuarioDTO dto) {
        Usuario usuario = usuarioService.guardarUsuario(dto);
        return ResponseEntity.ok(convertToDTO(usuario));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> obtenerTodos() {
        List<Usuario> lista = usuarioService.obtenerTodos();
        List<UsuarioDTO> dtos = new ArrayList<>();

        for (Usuario usuario : lista) {
            UsuarioDTO dto = convertToDTO(usuario);
            dtos.add(dto);
        }

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obtenerPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.obtenerPorId(id);
        if (usuario != null) {
            return ResponseEntity.ok(convertToDTO(usuario));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> actualizar(@PathVariable Long id, @RequestBody UsuarioDTO dto) {
        Usuario actualizado = usuarioService.actualizarUsuario(id, dto);
        if (actualizado != null) {
            return ResponseEntity.ok(convertToDTO(actualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    private UsuarioDTO convertToDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setCorreo(usuario.getCorreo());
        dto.setContraseña(usuario.getContraseña());
        dto.setRol(usuario.getRol());
        return dto;
    }
}

