package com.api.gestion.services.impl;

import com.api.gestion.DTO.ProponenteDTO;
import com.api.gestion.entities.ProponenteEntity;
import com.api.gestion.mapa.IProponenteMapa;
import com.api.gestion.repositories.IProponenteRepositorio;
import com.api.gestion.services.ProponenteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ProponenteServicioImpl implements ProponenteServicio {

    @Autowired
    IProponenteMapa iProponenteMapa;

    @Autowired
    IProponenteRepositorio iProponenteRepositorio;

    @Override
    public ProponenteDTO agregarProponente(ProponenteEntity datosProponente) throws Exception {
        try {

            return iProponenteMapa.proponenteToDTO(iProponenteRepositorio.save(datosProponente));


        } catch (Exception error) {
            throw new Exception(error.getMessage());

        }
    }

    @Override
    public ProponenteDTO buscarProponentePorId(Integer id) throws Exception {
        Optional<ProponenteEntity> proponenteOptional = this.iProponenteRepositorio.findById(id);
        if (proponenteOptional.isPresent()) {
            return this.iProponenteMapa.proponenteToDTO(proponenteOptional.get());
        } else {
            throw new Exception(" proponente no encontrado con el ID proporcionado: " + id);
        }
    }

    @Override
    public List<ProponenteDTO> buscarTodosProponente() throws Exception {
        try {
            return this.iProponenteMapa.toDTOList(iProponenteRepositorio.findAll());

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public ProponenteDTO modificarProponente(Integer id, ProponenteEntity Proponente) throws Exception {
        try {
            if (this.iProponenteRepositorio.findById(id).isPresent()) {
                //cambielo
                ProponenteEntity objetoEncontrado = this.iProponenteRepositorio.findById(id).get();
                objetoEncontrado.setProponente_id(Proponente.getProponente_id());
                objetoEncontrado.setNombre_proponente(Proponente.getNombre_proponente());
                objetoEncontrado.setTrayectoria(Proponente.getTrayectoria());

                return this.iProponenteMapa.proponenteToDTO(iProponenteRepositorio.save(objetoEncontrado));
            } else {
                //diga que no esta
                throw new Exception("Tipo Documento no encontrado");
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public Boolean eliminaProponente(Integer id){
        Optional<ProponenteEntity> eliminarProponente = iProponenteRepositorio.findById(id);

        if (eliminarProponente.isEmpty())
            return false;

        iProponenteRepositorio.deleteById(id);

        return true;
    }

}
