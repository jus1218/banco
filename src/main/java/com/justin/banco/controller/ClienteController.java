package com.justin.banco.controller;

import jakarta.validation.Valid;


import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.justin.banco.dto.cliente.ClientPaginationDTO;
import com.justin.banco.service.ClienteService;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    // repository
    private @Autowired ClienteService clienteService;

    @GetMapping("")
    public List<Map<String, Object>> getClients(@RequestBody @Valid ClientPaginationDTO param)
    throws JsonMappingException, JsonProcessingException  {
        return this.clienteService.getBanksInJson(param);
    }
}
