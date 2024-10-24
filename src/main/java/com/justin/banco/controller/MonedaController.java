package com.justin.banco.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.justin.banco.dto.moneda.MonedaCreateDTO;
import com.justin.banco.dto.moneda.MonedaPaginationDTO;
import com.justin.banco.dto.moneda.MonedaUpdateDTO;
import com.justin.banco.dto.moneda.MonedaInfoDTO;
import com.justin.banco.helpers.Result;
import com.justin.banco.models.Moneda;
import com.justin.banco.service.MonedaService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/moneda")
public class MonedaController {

    private @Autowired MonedaService monedaService;

    @GetMapping("/{id}")
    public Result<MonedaInfoDTO> getCurrencyById(@PathVariable("id") String id) {
        return this.monedaService.getById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Result<MonedaInfoDTO>> createCurrency(@RequestBody @Valid MonedaCreateDTO entity) {

        var result = this.monedaService.create(entity);
        return new ResponseEntity<Result<MonedaInfoDTO>>(result, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public Result<MonedaInfoDTO> updatedCurrency(@PathVariable("id") String id,
            @RequestBody @Valid MonedaUpdateDTO currency) {
        return this.monedaService.update(currency.copyWith(id));
    }

    @DeleteMapping("/{id}")
    public Result<String> deleteCurrency(@PathVariable("id") String id) {
        return this.monedaService.delete(id);
    }

    @GetMapping("")
    public Result<List<Moneda>> getCurrenciesAsJson(
            @RequestParam(required = false) Integer offset,
            @RequestParam(required = false) Integer limit,
            @RequestParam(required = false) String codigoMoneda,
            @RequestParam(required = false) String nombre) {

        var pagination = new MonedaPaginationDTO(
                offset != null ? offset : 0,
                limit != null ? limit : 300, // valor por defecto
                codigoMoneda,
                nombre);

        return this.monedaService.getList(pagination);
    }

}
