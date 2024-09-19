package com.justin.banco.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
 
import com.justin.banco.dto.banco.BancoCreateDTO;
import com.justin.banco.dto.banco.BancoInfoDTO;
import com.justin.banco.dto.banco.BancoUpdateDTO;
import com.justin.banco.dto.banco.BancoPaginationDTO;
import com.justin.banco.helpers.Result;
import com.justin.banco.models.Banco;
import com.justin.banco.service.BancoService;

import jakarta.validation.Valid;

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
    public Result<List<Banco>> getBancos(@RequestBody @Valid BancoPaginationDTO pagination)
            throws JsonMappingException, JsonProcessingException {
        return this.bancoService.getBanksInJson(pagination);
    }

    // http://localhost:8080/bancos/create
    @PostMapping("/create")
    public ResponseEntity<Result<BancoInfoDTO>> createBanco(@Valid @RequestBody BancoCreateDTO banco)
            throws Exception {
        var result = this.bancoService.create(banco);

        return new ResponseEntity<Result<BancoInfoDTO>>(result, HttpStatus.CREATED);
    }

    // http://localhost:8080/bancos/BN
    @GetMapping("/search/{name}")
    public Result<BancoInfoDTO> findBankByName(@PathVariable("name") String name) {

        return bancoService.getById(name);
    }

    @PatchMapping("/{id}")
    public Result<BancoInfoDTO> updateBankById(@PathVariable String id, @Valid @RequestBody BancoUpdateDTO banco) {

        return this.bancoService.update(banco.copyWith(id));
    }

    @DeleteMapping("/{id}")
    public Result<String> deleteBankById(@PathVariable String id) {
        return this.bancoService.delete(id);
    }

}