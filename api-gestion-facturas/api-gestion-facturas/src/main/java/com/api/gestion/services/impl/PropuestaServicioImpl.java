package com.api.gestion.services.impl;

import com.api.gestion.DTO.PropuestaDTO;
import com.api.gestion.entities.PropuestaEntity;
import com.api.gestion.mapa.IPropuestaMapa;
import com.api.gestion.repositories.IPropuestaRepositorio;
import com.api.gestion.services.PropuestaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PropuestaServicioImpl implements PropuestaServicio {

    @Autowired
    IPropuestaRepositorio iPropuestaRepositorio;

    @Autowired
    IPropuestaMapa iPropuestaMapa;

    @Override
    public PropuestaDTO guardarPropuesta(PropuestaEntity datosPropuesta)throws Exception{
        try {
            return this.iPropuestaMapa.propuestaToDTO(this.iPropuestaRepositorio.save(datosPropuesta));
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public PropuestaDTO buscarPropuesta(Integer id) throws Exception {
        Optional<PropuestaEntity> propuestaOptional = this.iPropuestaRepositorio.findById(id);
        if (propuestaOptional.isPresent()){
            return this.iPropuestaMapa.propuestaToDTO(propuestaOptional.get());
        }else {
            throw new Exception("Propuesta no encontrada con el ID proporcionado " + id);
        }
    }
    @Override
    public List<PropuestaDTO> buscarTodasLasPropuestas()throws Exception{
        try {
           return this.iPropuestaMapa.toDtoList(iPropuestaRepositorio.findAll());
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public PropuestaDTO modificarPropuesta(Integer id, PropuestaEntity propuesta) throws Exception{
        try {
            if (this.iPropuestaRepositorio.findById(id).isPresent()){
                PropuestaEntity objetosEncontrado = this.iPropuestaRepositorio.findById(id).get();
                objetosEncontrado.setNombre_propuesta(propuesta.getNombre_propuesta());
                objetosEncontrado.setId_propuesta(propuesta.getId_propuesta());
                objetosEncontrado.setDescripcion_propuesta(propuesta.getDescripcion_propuesta());
                objetosEncontrado.setDescripcion_actividades(propuesta.getDescripcion_actividades());
                objetosEncontrado.setFecha_presentacion(propuesta.getFecha_presentacion());
                objetosEncontrado.setFecha_inicio_evento(propuesta.getFecha_inicio_evento());
                objetosEncontrado.setEmpresas_aliadas(propuesta.getEmpresas_aliadas());
                objetosEncontrado.setPublico_beneficiado(propuesta.getPublico_beneficiado());

                return this.iPropuestaMapa.propuestaToDTO(iPropuestaRepositorio.save(objetosEncontrado));
            }else {
                throw new Exception("Propuesta no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public Boolean eliminarPropuesta(Integer id){
        Optional<PropuestaEntity> eliminarPropuesta = iPropuestaRepositorio.findById(id);

        if (eliminarPropuesta.isEmpty())
            return false;

        iPropuestaRepositorio.deleteById(id);

        return true;
    }
}
