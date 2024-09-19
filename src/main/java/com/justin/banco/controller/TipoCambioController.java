package com.justin.banco.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.justin.banco.dto.tipocambio.TipoCambioCreateDTO;
import com.justin.banco.dto.tipocambio.TipoCambioDeleteAndUpdateDTO;
import com.justin.banco.dto.tipocambio.TipoCambioInfoDTO;
import com.justin.banco.dto.tipocambio.TipoCambioPaginationDTO;
import com.justin.banco.helpers.Result;
import com.justin.banco.models.TipoCambio;
import com.justin.banco.service.TipoCambioService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/tipoCambio")
public class TipoCambioController {

    private @Autowired TipoCambioService tipoCambioService;

    @GetMapping("")
    public Result<List<TipoCambio>> getExchangeRates(
            @RequestBody @Valid TipoCambioPaginationDTO tipoCambioPaginacion) {
        return this.tipoCambioService.getBanksInJson(tipoCambioPaginacion);
    }

    @PostMapping("/create")
    public Result<TipoCambioInfoDTO> createExchangeRate(@RequestBody @Valid TipoCambioCreateDTO entity) {
        return this.tipoCambioService.create(entity);
    }

    @DeleteMapping("/delete")
    public Result<TipoCambioInfoDTO> deleteExchangeRate(@RequestBody @Valid TipoCambioDeleteAndUpdateDTO entity) {
        return this.tipoCambioService.DeleteByCompositePrimaryKey(entity);
    }

    @GetMapping("/get")
    public Result<TipoCambioInfoDTO> getExchangeRate(@RequestBody @Valid TipoCambioDeleteAndUpdateDTO entity) {
        return this.tipoCambioService.getByCompositePrimaryKey(entity);
    }

}
