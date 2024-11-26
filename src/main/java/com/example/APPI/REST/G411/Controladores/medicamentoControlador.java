package com.example.APPI.REST.G411.Controladores;

import com.example.APPI.REST.G411.MODELOS.Medicamento;
import com.example.APPI.REST.G411.MODELOS.Medico;
import com.example.APPI.REST.G411.Servicios.MedicamentoServicio;
import com.example.APPI.REST.G411.Servicios.MedicoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medicamento")
public class medicamentoControlador {
    @Autowired
    MedicamentoServicio medicamentoServicio;
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Medicamento datos){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(medicamentoServicio.registrarMedicamento(datos));
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
                    .body(medicamentoServicio.buscarMedicamento());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
