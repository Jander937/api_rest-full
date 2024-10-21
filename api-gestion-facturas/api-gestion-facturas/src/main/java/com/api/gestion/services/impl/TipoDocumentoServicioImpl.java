package com.api.gestion.services.impl;

import com.api.gestion.DTO.TipoDocumentoDTO;
import com.api.gestion.entities.TipoDocumentoEntity;
import com.api.gestion.mapa.ITipoDocumentoMapa;
import com.api.gestion.repositories.ITipODocumentoRepositorio;
import com.api.gestion.services.TipoDocumentoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDocumentoServicioImpl implements TipoDocumentoServicio {

    @Autowired
    ITipODocumentoRepositorio iTipODocumentoRepositorio;

    @Autowired
    ITipoDocumentoMapa iTipoDocumentoMapa;

    //Rutina para guardar en BD un tipoDocumento
    @Override
    public TipoDocumentoDTO agregarTipODocumento(TipoDocumentoEntity datosTipoDocumento) throws Exception{
        try{
            //validar primero

            //llamar al repo para ejecutar la consulta
            return this.iTipoDocumentoMapa.tipoDocumentoTODTO(this.iTipODocumentoRepositorio.save(datosTipoDocumento));


        }catch(Exception error){
            throw new Exception(error.getMessage());

        }

    }


    //RUTINA PARA BUSCAR UN ELEMENTO DENTRO BD POR ID
    @Override
    public TipoDocumentoDTO buscarTipoDocumentoPorId(Integer id) throws Exception {
        Optional<TipoDocumentoEntity> tipoDocumentoOptional = this.iTipODocumentoRepositorio.findById(id);
        if (tipoDocumentoOptional.isPresent()) {
            return this.iTipoDocumentoMapa.tipoDocumentoTODTO(tipoDocumentoOptional.get());
        } else {
            throw new Exception("Tipo de documento no encontrado con el ID proporcionado: " + id);
        }
    }

    @Override
    public List<TipoDocumentoDTO> buscarTodosTiposDocumentos() throws Exception{
        try{
            return this.iTipoDocumentoMapa.toDtoList(iTipODocumentoRepositorio.findAll());

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public TipoDocumentoDTO modificarTipoDocumento(Integer id, TipoDocumentoEntity tipoDocumento) throws Exception{
        try{
            if(this.iTipODocumentoRepositorio.findById(id).isPresent()){
                //cambielo
                TipoDocumentoEntity objetoEncontrado=this.iTipODocumentoRepositorio.findById(id).get();
                objetoEncontrado.setTipo_documento(tipoDocumento.getTipo_documento());
                return this.iTipoDocumentoMapa.tipoDocumentoTODTO(iTipODocumentoRepositorio.save(objetoEncontrado));
            }else{
                //diga que no esta
                throw new Exception("Tipo Documento no encontrado");
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public Boolean eliminaTipoDocumento(Integer id){
        Optional<TipoDocumentoEntity> eliminarTipoDocumento = iTipODocumentoRepositorio.findById(id);

        if (eliminarTipoDocumento.isEmpty())
            return false;

        iTipODocumentoRepositorio.deleteById(id);

        return true;
    }

}
