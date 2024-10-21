package com.api.gestion.controllers;

import com.api.gestion.DTO.errorDTO.TipoProponenteErrorDTO;
import com.api.gestion.entities.TipoProponenteEntity;
import com.api.gestion.services.impl.TipoProponenteServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v5/Tproponente")
public class TipoProponenteControlador {

    @Autowired
    TipoProponenteServicioImpl tipoProponenteServicio;

    @PostMapping("/save")
    public ResponseEntity<?> agregarTipoProponente(@RequestBody TipoProponenteEntity datosRecibidos) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.tipoProponenteServicio.agregarTipoProponente(datosRecibidos));
        } catch (Exception e) {
            TipoProponenteErrorDTO errorPersonalizado = new TipoProponenteErrorDTO();
            errorPersonalizado.setMensajeError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorPersonalizado.getMensajeError());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>BuscarUnTipoProponentePorId(@PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.tipoProponenteServicio.buscarTipoProponentePorId(id));
        }catch( Exception error){

            TipoProponenteErrorDTO errorPersonalizado=new TipoProponenteErrorDTO();
            errorPersonalizado.setMensajeError(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorPersonalizado.getMensajeError());
        }

    }
    @GetMapping("/seach")
    public ResponseEntity<?>buscarTipoProponente(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.tipoProponenteServicio.buscarTodosTipoProponente());
        }catch( Exception error){

            TipoProponenteErrorDTO errorPersonalizado=new TipoProponenteErrorDTO();
            errorPersonalizado.setMensajeError(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorPersonalizado.getMensajeError());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> modificarTipoProponente(@RequestBody TipoProponenteEntity datosRecibidos, @PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(this.tipoProponenteServicio.modificarTipoproponente(id, datosRecibidos));
        } catch (Exception error) {

            TipoProponenteErrorDTO errorPersonalizado = new TipoProponenteErrorDTO();
            errorPersonalizado.setMensajeError(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorPersonalizado.getMensajeError());
        }
    }
    @DeleteMapping(value = "/Tproponente/{id}")
    public Optional<ResponseEntity<?>> eliminar(@PathVariable int id){

        Boolean result = tipoProponenteServicio.eliminaTipoProponente(id);

        if(result){
            return Optional.of(ResponseEntity.noContent().build());
        }
        return Optional.of(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
