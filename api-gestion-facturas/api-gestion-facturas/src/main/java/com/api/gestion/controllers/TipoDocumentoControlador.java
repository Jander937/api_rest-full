package com.api.gestion.controllers;


import com.api.gestion.DTO.errorDTO.TipoDocumentoErrorDTO;
import com.api.gestion.entities.TipoDocumentoEntity;
import com.api.gestion.services.impl.TipoDocumentoServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/documento")
public class TipoDocumentoControlador {

    @Autowired
    TipoDocumentoServicioImpl tipoDocumentoServicio;

    @PostMapping("/save")
    public ResponseEntity<?> agregarTipoDocumento(@RequestBody TipoDocumentoEntity datosRecibidos){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.tipoDocumentoServicio.agregarTipODocumento(datosRecibidos));
        } catch (Exception e) {
            TipoDocumentoErrorDTO errorPersonalizado = new TipoDocumentoErrorDTO();
            errorPersonalizado.setMensajeError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorPersonalizado.getMensajeError());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>BuscarUnDocumento(@PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.tipoDocumentoServicio.buscarTipoDocumentoPorId(id));
        }catch( Exception error){

            TipoDocumentoErrorDTO errorPersonalizado=new TipoDocumentoErrorDTO();
            errorPersonalizado.setMensajeError(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorPersonalizado.getMensajeError());
        }

    }

    @GetMapping("/seach")
    public ResponseEntity<?>buscarDocumentos(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.tipoDocumentoServicio.buscarTodosTiposDocumentos());
        }catch( Exception error){

            TipoDocumentoErrorDTO errorPersonalizado=new TipoDocumentoErrorDTO();
            errorPersonalizado.setMensajeError(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorPersonalizado.getMensajeError());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarDocumento(@RequestBody TipoDocumentoEntity datosRecibidos, @PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(this.tipoDocumentoServicio.modificarTipoDocumento(id, datosRecibidos));
        }catch( Exception error){

            TipoDocumentoErrorDTO errorPersonalizado=new TipoDocumentoErrorDTO();
            errorPersonalizado.setMensajeError(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorPersonalizado.getMensajeError());
        }
    }
    @DeleteMapping(value = "/documento/{id}")
    public Optional<ResponseEntity<?>> eliminar(@PathVariable int id){

        Boolean result = tipoDocumentoServicio.eliminaTipoDocumento(id);

        if(result){
            return Optional.of(ResponseEntity.noContent().build());
        }
        return Optional.of(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
