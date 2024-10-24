package com.justin.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.justin.banco.dto.cuentacliente.CuentaClienteCreateDTO;
import com.justin.banco.dto.cuentacliente.CuentaClienteInfoDTO;
import com.justin.banco.dto.cuentacliente.CuentaClientePaginacionDTO;
import com.justin.banco.dto.cuentacliente.CuentaClienteUpdateDTO;
import com.justin.banco.helpers.Result;
import com.justin.banco.models.CuentaCliente;
import com.justin.banco.models.Selector;
import com.justin.banco.service.CuentaClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cuenta-cliente")
public class CuentaClienteController {

    private @Autowired CuentaClienteService cuentaClienteService;

    @GetMapping("")
    public Result<List<CuentaCliente>> getClientAccount(
            @RequestParam(required = true) Integer offset,
            @RequestParam(required = true) Integer limit,
            @RequestParam(required = false) Integer codigoCliente) {

        var param = new CuentaClientePaginacionDTO(offset, limit, codigoCliente);
        return this.cuentaClienteService.getList(param);
    }

    @PostMapping("/create")
    public ResponseEntity<Result<CuentaClienteInfoDTO>> createBanco(
            @Valid @RequestBody CuentaClienteCreateDTO cliente) {

        var result = this.cuentaClienteService.create(cliente);
        return new ResponseEntity<Result<CuentaClienteInfoDTO>>(result, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Result<CuentaClienteInfoDTO> getClientAccountById(@PathVariable("id") Long id) {
        return this.cuentaClienteService.getById(id);
    }

    @GetMapping("/selectores")
    public Result<Selector> getDataSelectores() {
        return this.cuentaClienteService.getDataSelectores();
    }

    @PatchMapping("/{id}")
    public Result<CuentaClienteInfoDTO> update(@PathVariable Long id,
            @Valid @RequestBody CuentaClienteUpdateDTO cliente) {
        return this.cuentaClienteService.update(cliente.copyWith(id));
    }

    @DeleteMapping("/{id}")
    public Result<String> deleteById(@PathVariable("id") Long id) {
        return this.cuentaClienteService.delete(id);
    }
}
