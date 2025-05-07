// EstudianteRepository.java
package com.example.appStudents.repository;

import com.example.appStudents.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}
