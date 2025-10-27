package com.example.FrankySabado.controladores;

import com.example.FrankySabado.modelos.dtos.AsistenciaDTO;
import com.example.FrankySabado.servicios.AsistenciaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asistencias")
public class AsistenciaControlador {

    @Autowired
    private AsistenciaServicio asistenciaServicio;

    @GetMapping
    public ResponseEntity<?> listarTodas() {
        try {
            List<AsistenciaDTO> lista = asistenciaServicio.listarTodas();
            return ResponseEntity.ok(lista);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al listar asistencias.");
        }
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody AsistenciaDTO dto) {
        try {
            AsistenciaDTO creado = asistenciaServicio.crearAsistencia(dto);
            return ResponseEntity.ok(creado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al crear la asistencia.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody AsistenciaDTO dto) {
        try {
            AsistenciaDTO actualizado = asistenciaServicio.actualizarAsistencia(id, dto);
            return ResponseEntity.ok(actualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al actualizar la asistencia.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            asistenciaServicio.eliminarAsistencia(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al eliminar la asistencia.");
        }
    }
}