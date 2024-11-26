package com.example.APPI.REST.G411.Servicios;

import com.example.APPI.REST.G411.MODELOS.Enfermedad;
import com.example.APPI.REST.G411.repositorios.IRepositorioEnfermedad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnfermedadServicio {
    @Autowired
    IRepositorioEnfermedad IRepositorioEnfermedad;

    public Enfermedad registrarEnfermedad(Enfermedad datosEnfermedad) throws Exception{
        try{
            // guardar en la BBDD los datos del paciente
            return IRepositorioEnfermedad.save(datosEnfermedad);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Enfermedad buscarEnfermedad() throws Exception {
        try{
            return (Enfermedad) IRepositorioEnfermedad.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Enfermedad buscarEnfermedadId(Enfermedad datosEnfermedad){
        return null;
    }
}
