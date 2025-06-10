package com.example.appStudents;

import com.example.appStudents.model.Asignatura;
import com.example.appStudents.model.Asistencia;
import com.example.appStudents.model.Estudiantes;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class AsistenciaTest {

    @Test
    public void probarGettersSettersAsistencia() {
        // Crear objetos relacionados
        Estudiantes estudiante = new Estudiantes();
        estudiante.setId(1L);
        estudiante.setNombre("Ana");

        Asignatura asignatura = new Asignatura();
        asignatura.setId(1L);
        asignatura.setNombre("Matemáticas");

        LocalDate fecha = LocalDate.of(2025, 6, 9);

        // Crear asistencia y asignar datos
        Asistencia asistencia = new Asistencia();
        asistencia.setId(1L);
        asistencia.setEstudiante(estudiante);
        asistencia.setAsignatura(asignatura);
        asistencia.setFecha(fecha);
        asistencia.setEstado(true); // asistió

        // Verificar con asserts que los valores se asignaron correctamente
        assertEquals(1L, asistencia.getId());
        assertEquals("Ana", asistencia.getEstudiante().getNombre());
        assertEquals("Matemáticas", asistencia.getAsignatura().getNombre());
        assertEquals(fecha, asistencia.getFecha());
        assertTrue(asistencia.getEstado());
    }
}
