package com.example.APPI.REST.G411.Controladores;

import com.example.APPI.REST.G411.MODELOS.Paciente;
import com.example.APPI.REST.G411.MODELOS.signoVital;
import com.example.APPI.REST.G411.Servicios.PacienteServicio;
import com.example.APPI.REST.G411.Servicios.SignoVitalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/signoVital")
public class signoVitalControlador {
    @Autowired
    SignoVitalServicio signoVitalServicio;
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody signoVital datos){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(signoVitalServicio.registrarSignoVital(datos));
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
                    .body(signoVitalServicio.buscarSignoVital());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
