package com.justin.banco.controller;

import org.springframework.web.bind.annotation.RestController;

import com.justin.banco.helpers.Result;
import com.justin.banco.models.Provincia;
import com.justin.banco.service.UbicacionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping; 


@RestController 
@RequestMapping(path = "/ubicacion")
public class UbicacionController {

    private @Autowired UbicacionService ubicacionService;

    @GetMapping("") 
    public Result<List<Provincia>> getProvinciasCantonesDistritos() {
        return this.ubicacionService.getProvinciasCantonesDistritos();
    }
}
