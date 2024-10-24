package com.justin.banco.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.justin.banco.dto.tipocambio.TipoCambioCreateDTO;
import com.justin.banco.dto.tipocambio.TipoCambioDeleteAndUpdateDTO;
import com.justin.banco.dto.tipocambio.TipoCambioInfoDTO;
import com.justin.banco.dto.tipocambio.TipoCambioPaginationDTO;
import com.justin.banco.dto.tipocambio.TipoCambioUpdateDTO;
import com.justin.banco.helpers.Result;
import com.justin.banco.models.TipoCambio;
import com.justin.banco.service.TipoCambioService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/tipoCambio")
public class TipoCambioController {

    private @Autowired TipoCambioService tipoCambioService;

    @GetMapping("")
    public Result<List<TipoCambio>> getExchangeRates(
            @RequestParam(required = false) Integer offset,
            @RequestParam(required = false) Integer limit,
            @RequestParam(required = false) String codigoMoneda,
            @RequestParam(required = false) String fecha,
            @RequestParam(required = false) String codigoBanco) {

        var tipoCambioPaginacion = new TipoCambioPaginationDTO(offset, limit, codigoMoneda, fecha, codigoBanco);
        return this.tipoCambioService.getList(tipoCambioPaginacion);
    }

    @PostMapping("/create")
    public Result<TipoCambioInfoDTO> createExchangeRate(@RequestBody @Valid TipoCambioCreateDTO entity) {
        return this.tipoCambioService.create(entity);
    }

    @DeleteMapping("/delete")
    public Result<TipoCambioInfoDTO> deleteExchangeRate(
            @RequestParam(required = true) String codigoMoneda,
            @RequestParam(required = true) String fecha,
            @RequestParam(required = true) String codigoBanco) {

        var entity = new TipoCambioDeleteAndUpdateDTO(codigoMoneda, fecha, codigoBanco);
        return this.tipoCambioService.DeleteByCompositePrimaryKey(entity);
    }

    @GetMapping("/get")
    public Result<TipoCambioInfoDTO> getExchangeRate(
            @RequestParam(required = true) String codigoMoneda,
            @RequestParam(required = true) String fecha,
            @RequestParam(required = true) String codigoBanco) {

        var entity = new TipoCambioDeleteAndUpdateDTO(codigoMoneda, fecha, codigoBanco);
        return this.tipoCambioService.getByCompositePrimaryKey(entity);
    }

    @PatchMapping("/update")
    public Result<TipoCambioInfoDTO> updateBankById(@Valid @RequestBody TipoCambioUpdateDTO tipoCambio) {

        return this.tipoCambioService.update(tipoCambio);
    }

}
