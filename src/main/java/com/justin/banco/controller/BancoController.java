package com.justin.banco.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.justin.banco.dto.banco.BancoCreateDTO;
import com.justin.banco.dto.banco.BancoUpdateDTO;
import com.justin.banco.dto.banco.BancoPaginationDTO;
import com.justin.banco.helpers.Result;
import com.justin.banco.models.Banco;
import com.justin.banco.service.BancoService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(path = "/bancos")
public class BancoController {

    private @Autowired BancoService bancoService;

    // http://localhost:8080/bancos
    // @GetMapping("")
    // public Result<List<Banco>> getBancos() throws Exception {
    // return this.bancoService.getAll();
    // }
    @GetMapping("")
    public List<Map<String, Object>> getBancos(@RequestBody @Valid BancoPaginationDTO pagination) throws JsonMappingException, JsonProcessingException  {
        return this.bancoService.getBanksInJson(pagination);
    }

    // http://localhost:8080/bancos/cuentas-cliente
    @GetMapping("/cuentas-cliente")
    public Result<String> getCuentasClientePorBanco() {
        return Result.success("Cuentas clientes", "");
    }

    // http://localhost:8080/bancos/create
    @PostMapping("/create")
    public Result<BancoCreateDTO> createBanco(@Valid @RequestBody BancoCreateDTO banco) throws Exception {

        return this.bancoService.create(banco);
    }

    // http://localhost:8080/bancos/BN
    @GetMapping("/search/{name}")
    public Result<List<Banco>> findBankByName(@PathVariable("name") String name) {

        return bancoService.getByName(name);
    }

    @PutMapping("/{id}")
    public Result<BancoUpdateDTO> updateBankById(@PathVariable String id, @RequestBody BancoUpdateDTO banco) {

        return this.bancoService.update(id, banco);
    }

    @DeleteMapping("/{id}")
    public Result<String> deleteBankById(@PathVariable String id) {
        return this.bancoService.delete(id);
    }

}