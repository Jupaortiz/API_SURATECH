package com.example.APPI.REST.G411.Controladores;

import com.example.APPI.REST.G411.MODELOS.Medico;
import com.example.APPI.REST.G411.MODELOS.signoVital;
import com.example.APPI.REST.G411.Servicios.MedicoServicio;
import com.example.APPI.REST.G411.Servicios.SignoVitalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medico")
public class medicoControlador {
    @Autowired
    MedicoServicio medicoServicio;
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Medico datos){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(medicoServicio.registrarMedico(datos));
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
                    .body(medicoServicio.buscarMedico());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
