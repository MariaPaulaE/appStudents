package com.example.appStudents.service;

import com.example.appStudents.dto.UsuarioDTO;
import com.example.appStudents.model.Usuario;
import com.example.appStudents.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario guardarUsuario(UsuarioDTO dto) {
        Usuario usuario = new Usuario(dto.getCorreo(), dto.getContraseña(), dto.getRol());
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario obtenerPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario actualizarUsuario(Long id, UsuarioDTO dto) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setCorreo(dto.getCorreo());
            usuario.setContraseña(dto.getContraseña());
            usuario.setRol(dto.getRol());
            return usuarioRepository.save(usuario);
        }).orElse(null);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
