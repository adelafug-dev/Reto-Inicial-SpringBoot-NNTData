package reto.spring.retoinicialspringboot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reto.spring.retoinicialspringboot.entity.Languaje;
import reto.spring.retoinicialspringboot.service.LanguajeService;

import java.util.List;

@RestController
@RequestMapping(value = "/languajes")
public class LanguajeController {

    @Autowired
    LanguajeService languajeService;

    @Tag(name = "GET")
    @Operation(summary = "Get All Languajes", description = "Get All Hellow World in differents idioms")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of Languajes found"),
            @ApiResponse(responseCode = "404", description = "List of Languajes not found")
    })
    @GetMapping
    public List<Languaje> findAllLanguajes( ){
        List<Languaje> languajes = languajeService.listAllLanguajes();
        for (Languaje languajesUpperCase : languajes){
            languajesUpperCase.setIso(languajesUpperCase.getIso().toUpperCase());
            languajesUpperCase.setMessage(languajesUpperCase.getMessage().toUpperCase());
        }
        return languajes;
    }

    @Tag(name = "GET")
    @Operation(summary = "Get one Languaje", description = "Get one Languaje find by ISO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Languaje found"),
            @ApiResponse(responseCode = "404", description = "Languaje not found")
    })
    @GetMapping(value = "/{iso}")
    public ResponseEntity<Languaje> getLanguajeByIso(@PathVariable("iso") String iso){
        Languaje getLanguaje = languajeService.getLanguajeByIso(iso);
        getLanguaje.setIso(getLanguaje.getIso().toUpperCase());
        getLanguaje.setMessage(getLanguaje.getMessage().toUpperCase());
        if (getLanguaje == null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(getLanguaje);
    }

    @Tag(name = "POST")
    @Operation(summary = "Create a new Languaje", description = "Create New Languajes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Language created successful"),
            @ApiResponse(responseCode = "404", description = "Error to create the Languaje")
    })
    @PostMapping
    public Languaje createLanguaje(@RequestBody Languaje languaje){
        Languaje newLanguaje = languajeService.createLanguaje(languaje);
        newLanguaje.setIso(newLanguaje.getIso().toUpperCase());
        newLanguaje.setMessage(newLanguaje.getMessage().toUpperCase());
        return newLanguaje;
    }

    @Tag(name = "PUT")
    @Operation(summary = "Update a Languaje", description = "Update a Languaje that has been created already")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Language updated successful"),
            @ApiResponse(responseCode = "404", description = "Error to uptade the Languaje")
    })
    @PutMapping(value = "/{iso}")
    public ResponseEntity<Languaje> updateLanguaje(@PathVariable("iso") String iso, @RequestBody Languaje languaje){
        languaje.setIso(iso);
        Languaje languajeDB = languajeService.updateLanguaje(languaje);
        if (languajeDB == null){
            return ResponseEntity.notFound().build();
        }
        languajeDB.setIso(languaje.getIso().toUpperCase());
        languajeDB.setMessage(languaje.getMessage().toUpperCase());
        return ResponseEntity.ok(languajeDB);
    }

    @Tag(name = "DELETE")
    @Operation(summary = "Delete a Languaje", description = "Delete a Languaje that exist already")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Language deleted successful"),
            @ApiResponse(responseCode = "404", description = "Error to delete the Languaje")
    })
    @DeleteMapping(value = "/{iso}")
    public ResponseEntity<Languaje> deleteLanguaje(@PathVariable("iso") String iso){
        Languaje languajeDeleted = languajeService.deleteLanguaje(iso);
        if(languajeDeleted == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(languajeDeleted);
    }

}
