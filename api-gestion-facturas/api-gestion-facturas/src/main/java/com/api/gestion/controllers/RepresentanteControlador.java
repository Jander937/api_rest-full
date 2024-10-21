package com.api.gestion.controllers;


import com.api.gestion.DTO.errorDTO.RepresentanteErrorDTO;
import com.api.gestion.entities.RepresentanteEntity;
import com.api.gestion.services.impl.RepresentanteServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v7/representante")
public class RepresentanteControlador {

    @Autowired
    RepresentanteServicioImpl representanteServicio;

    @PostMapping("/save")
    public ResponseEntity<?> agregarRepresentante(@RequestBody RepresentanteEntity datosRecibidos){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.representanteServicio.agregarRepresentante(datosRecibidos));
        } catch (Exception e) {
            RepresentanteErrorDTO errorPersonalizado = new RepresentanteErrorDTO();
            errorPersonalizado.setMensajeError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorPersonalizado.getMensajeError());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>BuscarRepresentantePorId(@PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.representanteServicio.buscarRepresentantePorId(id));
        }catch( Exception error){

            RepresentanteErrorDTO errorPersonalizado=new RepresentanteErrorDTO();
            errorPersonalizado.setMensajeError(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorPersonalizado.getMensajeError());
        }

    }
    @GetMapping("/seach")
    public ResponseEntity<?>buscarRepresentante(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.representanteServicio.buscarTodosLosRepresentantes());
        }catch( Exception error){

            RepresentanteErrorDTO errorPersonalizado=new RepresentanteErrorDTO();
            errorPersonalizado.setMensajeError(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorPersonalizado.getMensajeError());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> modificarRepresentante(@RequestBody RepresentanteEntity datosRecibidos, @PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(this.representanteServicio.modificarRepresentante(id, datosRecibidos));
        }catch( Exception error){

            RepresentanteErrorDTO errorPersonalizado=new RepresentanteErrorDTO();
            errorPersonalizado.setMensajeError(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorPersonalizado.getMensajeError());
        }
    }
    @DeleteMapping(value = "/representante/{id}")
    public Optional<ResponseEntity<?>> eliminar(@PathVariable int id){

        Boolean result = representanteServicio.eliminaRepresentante(id);

        if(result){
            return Optional.of(ResponseEntity.noContent().build());
        }
        return Optional.of(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

}
