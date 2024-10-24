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

import com.justin.banco.dto.cuentacontable.CuentaContableCreateDTO;
import com.justin.banco.dto.cuentacontable.CuentaContableInfoDTO;
import com.justin.banco.dto.cuentacontable.CuentaContablePaginationDTO;
import com.justin.banco.dto.cuentacontable.CuentaContableUpdateDTO;
import com.justin.banco.helpers.Result;
import com.justin.banco.models.CuentaContable;
import com.justin.banco.service.CuentaContableService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/cuenta-contable")
public class CuentaContableController {

    private @Autowired CuentaContableService cuentaContableService;

    @GetMapping("")
    public Result<List<CuentaContable>> getCuentaContables(
            @RequestParam(required = true) Integer offset,
            @RequestParam(required = true) Integer limit,
            @RequestParam(required = false) String codigoBanco) {

        var param = new CuentaContablePaginationDTO(offset, limit, codigoBanco);
        return this.cuentaContableService.getList(param);
    }

    @GetMapping("/{id}")
    public Result<CuentaContableInfoDTO> getCuentaContable(@PathVariable("id") Long id) {
        return this.cuentaContableService.getById(id);
    }

    @PatchMapping("/{id}")
    public Result<CuentaContableInfoDTO> updatedCuentaContable(@PathVariable("id") Long id,
            @RequestBody @Valid CuentaContableUpdateDTO currency) {
        return this.cuentaContableService.update(currency.copyWith(id));
    }

    @DeleteMapping("/{id}")
    public Result<String> deleteById(@PathVariable("id") Long id) {
        return this.cuentaContableService.delete(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Result<CuentaContableInfoDTO>> createBanco(@Valid @RequestBody CuentaContableCreateDTO banco)
            throws Exception {
        var result = this.cuentaContableService.create(banco);

        return new ResponseEntity<Result<CuentaContableInfoDTO>>(result, HttpStatus.CREATED);
    }

}
