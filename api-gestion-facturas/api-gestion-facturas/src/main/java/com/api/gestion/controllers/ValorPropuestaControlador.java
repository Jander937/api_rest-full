package com.api.gestion.controllers;

import com.api.gestion.DTO.errorDTO.ValorPropuestaErrorDTO;
import com.api.gestion.entities.ValorPropuestaEntity;
import com.api.gestion.services.impl.ValorPropuestaServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v8/valor")
public class ValorPropuestaControlador {

    @Autowired
    ValorPropuestaServicioImpl valorPropuestaServicio;

    @PostMapping("/save")
    public ResponseEntity<?> agregarValorPropuesta(@RequestBody ValorPropuestaEntity datosRecibidos) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.valorPropuestaServicio.agregarValorPropuesta(datosRecibidos));
        } catch (Exception e) {
            ValorPropuestaErrorDTO errorPersonalizado = new ValorPropuestaErrorDTO();
            errorPersonalizado.setMensajeError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorPersonalizado.getMensajeError());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>BuscarUnValorPropuestaPorId(@PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.valorPropuestaServicio.buscarValorPropuestaPorId(id));
        }catch( Exception error){

            ValorPropuestaErrorDTO errorPersonalizado=new ValorPropuestaErrorDTO();
            errorPersonalizado.setMensajeError(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorPersonalizado.getMensajeError());
        }

    }
    @GetMapping("/seach")
    public ResponseEntity<?>buscarValorPropuesta(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.valorPropuestaServicio.buscarTodosValorPropuesta());
        }catch( Exception error){

            ValorPropuestaErrorDTO errorPersonalizado=new ValorPropuestaErrorDTO();
            errorPersonalizado.setMensajeError(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorPersonalizado.getMensajeError());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> modificarTipoProponente(@RequestBody ValorPropuestaEntity datosRecibidos, @PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(this.valorPropuestaServicio.modificarValorPropuesta(id, datosRecibidos));
        } catch (Exception error) {

            ValorPropuestaErrorDTO errorPersonalizado = new ValorPropuestaErrorDTO();
            errorPersonalizado.setMensajeError(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorPersonalizado.getMensajeError());
        }
    }
    @DeleteMapping(value = "/Tproponente/{id}")
    public Optional<ResponseEntity<?>> eliminar(@PathVariable int id){

        Boolean result = valorPropuestaServicio.eliminarValorPropuesta(id);

        if(result){
            return Optional.of(ResponseEntity.noContent().build());
        }
        return Optional.of(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
