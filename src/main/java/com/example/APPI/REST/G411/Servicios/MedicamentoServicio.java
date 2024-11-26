package com.example.APPI.REST.G411.Servicios;

import com.example.APPI.REST.G411.MODELOS.Medicamento;
import com.example.APPI.REST.G411.repositorios.IRepositorioMedicamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicamentoServicio {
    @Autowired
    IRepositorioMedicamento IRepositorioMedicamento;

    public Medicamento registrarMedicamento(Medicamento datosMedicamento) throws Exception{
        try{
            // guardar en la BBDD los datos del paciente
            return IRepositorioMedicamento.save(datosMedicamento);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Medicamento buscarMedicamento() throws Exception {
        try{
            return (Medicamento) IRepositorioMedicamento.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Medicamento buscarMedicamentoId(Medicamento datosMedicamento){
        return null;
    }
}
