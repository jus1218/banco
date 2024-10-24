package com.justin.banco.controller;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.justin.banco.dto.Ubicacion.*;
import com.justin.banco.helpers.Result;
import com.justin.banco.models.Provincia;
import com.justin.banco.models.Ubicacion;
import com.justin.banco.service.UbicacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/ubicacion")
public class UbicacionController {

    private @Autowired UbicacionService ubicacionService;

    @GetMapping("")
    public Result<List<Provincia>> getProvinciasCantonesDistritos() {
        return this.ubicacionService.getProvinciasCantonesDistritos();
    }

    @PostMapping("/create")
    public ResponseEntity<Result<UbicacionInfoDTO>> createBanco(@Valid @RequestBody UbicationCreateDTO provincia) {

        var result = this.ubicacionService.createProvince(provincia);
        return new ResponseEntity<Result<UbicacionInfoDTO>>(result, HttpStatus.CREATED);
    }

    //
    @GetMapping("/get")
    public Result<UbicacionInfoDTO> getUbication(
            @RequestParam(required = true) String codigo,
            @RequestParam(required = true) Integer type) {

        return this.ubicacionService.getUbication(new Ubicacion(codigo, type));
    }

    @GetMapping("/provincias")
    public Result<List<ProvinciaDetailDTO>> getProvincies(
            @RequestParam(required = true) Integer offset,
            @RequestParam(required = true) Integer limit,
            @RequestParam(required = false) String nombre) {

        var pagination = new ProvinciaPaginationDTO(offset, limit, nombre);
        return this.ubicacionService.getProvincies(pagination);
    }

    @GetMapping("/provincia")
    public Result<Provincia> getProvincie(@RequestParam(required = true) Integer code) {

        return this.ubicacionService.getProvincie(code);
    }

    @PatchMapping("/{id}")
    public Result<UbicacionInfoDTO> updateUbication(@PathVariable Integer id,
            @Valid @RequestBody UbicationUpdatedDTO ubication) {
        return this.ubicacionService.updateUbication(ubication.copyWith(id));
    }

     

    @DeleteMapping("/delete")
    public Result<UbicacionInfoDTO> deleteUbicationById(
            @RequestParam(required = true) Integer codigo,
            @RequestParam(required = true) Integer type) {

        var ubication = new UbicationDeleteDTO(codigo, type);
        return this.ubicacionService.deleteUbicationById(ubication);
    }

}
