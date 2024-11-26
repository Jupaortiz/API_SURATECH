package com.example.APPI.REST.G411.Controladores;

import com.example.APPI.REST.G411.MODELOS.Enfermedad;
import com.example.APPI.REST.G411.MODELOS.Medicamento;
import com.example.APPI.REST.G411.Servicios.EnfermedadServicio;
import com.example.APPI.REST.G411.Servicios.MedicamentoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enfermedad")
public class enfermedadControlador {
    @Autowired
    EnfermedadServicio enfermedadServicio;
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Enfermedad datos){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(enfermedadServicio.registrarEnfermedad(datos));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity<?> buscarTodo() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(enfermedadServicio.buscarEnfermedad());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
