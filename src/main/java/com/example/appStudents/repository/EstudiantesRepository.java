// EstudianteRepository.java
package com.example.appStudents.repository;

import com.example.appStudents.model.Estudiantes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudiantesRepository extends JpaRepository<Estudiantes, Long> {

}

