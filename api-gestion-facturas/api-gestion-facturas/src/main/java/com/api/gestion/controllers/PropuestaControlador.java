package com.api.gestion.controllers;

import com.api.gestion.DTO.errorDTO.PropuestaErrorDTO;
import com.api.gestion.entities.PropuestaEntity;
import com.api.gestion.services.PropuestaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v4/propuesta")
public class PropuestaControlador {

    @Autowired
    PropuestaServicio propuestaServicio;

    @PostMapping("/save")
    public ResponseEntity<?> agregarPropuesta(@RequestBody PropuestaEntity datosRecibidos){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.propuestaServicio.guardarPropuesta(datosRecibidos));
        } catch (Exception e) {
            PropuestaErrorDTO errorPersonalizado = new PropuestaErrorDTO();
            errorPersonalizado.setMensajeError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorPersonalizado.getMensajeError());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPropuestaPorId(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.propuestaServicio.buscarPropuesta(id));
        } catch (Exception e) {
            PropuestaErrorDTO errorPersonalizado = new PropuestaErrorDTO();
            errorPersonalizado.setMensajeError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorPersonalizado.getMensajeError());
        }
    }
    @GetMapping("/seach")
    public ResponseEntity<?>buscarPropuestas(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.propuestaServicio.buscarTodasLasPropuestas());
        } catch (Exception e) {
            PropuestaErrorDTO errorPersonalizado = new PropuestaErrorDTO();
            errorPersonalizado.setMensajeError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorPersonalizado.getMensajeError());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> modificarPropuesta(@RequestBody PropuestaEntity datosRecibidos, @PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(this.propuestaServicio.modificarPropuesta(id, datosRecibidos));
        } catch (Exception e) {
            PropuestaErrorDTO errorPersonalizado = new PropuestaErrorDTO();
            errorPersonalizado.setMensajeError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorPersonalizado.getMensajeError());
        }
    }
    @DeleteMapping(value = "/propuesta/{id}")
    public Optional<ResponseEntity<?>> eliminar(@PathVariable int id){

        Boolean result = propuestaServicio.eliminarPropuesta(id);

        if (result){
            return Optional.of(ResponseEntity.noContent().build());
        }
        return Optional.of(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
