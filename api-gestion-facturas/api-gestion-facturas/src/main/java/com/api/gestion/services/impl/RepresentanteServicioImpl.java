package com.api.gestion.services.impl;


import com.api.gestion.DTO.RepresentanteDTO;
import com.api.gestion.entities.RepresentanteEntity;
import com.api.gestion.mapa.IRepresentanteMapa;
import com.api.gestion.repositories.IRepresentanteRepositorio;
import com.api.gestion.services.RepresentanteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepresentanteServicioImpl implements RepresentanteServicio {


    @Autowired
    IRepresentanteRepositorio iRepresentanteRepositorio;

    @Autowired
    IRepresentanteMapa iRepresentanteMapa;

    @Override
    public RepresentanteDTO agregarRepresentante(RepresentanteEntity datosRepresentante) throws Exception{
        try{
            //validar primero

            //llamar al repo para ejecutar la consulta
            return this.iRepresentanteMapa.representanteToDTO(this.iRepresentanteRepositorio.save(datosRepresentante));


        }catch(Exception error){
            throw new Exception(error.getMessage());

        }

    }

    @Override
    public RepresentanteDTO buscarRepresentantePorId(Integer id) throws Exception {
        Optional<RepresentanteEntity> representanteOptional = this.iRepresentanteRepositorio.findById(id);
        if (representanteOptional.isPresent()) {
            return this.iRepresentanteMapa.representanteToDTO(representanteOptional.get());
        } else {
            throw new Exception("Representante no encontrado con el ID proporcionado: " + id);
        }
    }
    @Override
    public List<RepresentanteDTO> buscarTodosLosRepresentantes() throws Exception{
        try{
            return this.iRepresentanteMapa.toDtoList(iRepresentanteRepositorio.findAll());

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public RepresentanteDTO modificarRepresentante(Integer id, RepresentanteEntity representante) throws Exception{
        try{
            if(this.iRepresentanteRepositorio.findById(id).isPresent()){
                //cambielo
                RepresentanteEntity objetoEncontrado=this.iRepresentanteRepositorio.findById(id).get();
                objetoEncontrado.setId_representante(representante.getId_representante());
                objetoEncontrado.setTipo_documento(representante.getTipo_documento());
                objetoEncontrado.setCorreo(representante.getCorreo());
                objetoEncontrado.setPrimer_nombre(representante.getPrimer_nombre());
                objetoEncontrado.setPrimer_apellido(representante.getPrimer_apellido());
                objetoEncontrado.setTelefono_celular(representante.getTelefono_celular());
                objetoEncontrado.setTelefono_fijo(representante.getTelefono_fijo());
                objetoEncontrado.setNumero_documento(representante.getNumero_documento());

                return this.iRepresentanteMapa.representanteToDTO(iRepresentanteRepositorio.save(objetoEncontrado));
            }else{
                //diga que no esta
                throw new Exception("Representante no encontrado");
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public Boolean eliminaRepresentante(Integer id){
        Optional<RepresentanteEntity> eliminarRepresentante = iRepresentanteRepositorio.findById(id);

        if (eliminarRepresentante.isEmpty())
            return false;

        iRepresentanteRepositorio.deleteById(id);

        return true;
    }



}
