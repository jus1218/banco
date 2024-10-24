package com.justin.banco.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import com.justin.banco.dto.cliente.ClientPaginationDTO;
import com.justin.banco.dto.cliente.ClienteCreateDTO;
import com.justin.banco.dto.cliente.ClienteInfoDTO;
import com.justin.banco.dto.cliente.ClienteUpdateDTO;
import com.justin.banco.service.ClienteService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.justin.banco.helpers.Result;
import com.justin.banco.models.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    // repository
    private @Autowired ClienteService clienteService;

    @GetMapping("")
    public Result<List<Cliente>> getClients(
            @RequestParam(required = true) Integer offset,
            @RequestParam(required = true) Integer limit,
            @RequestParam(required = false) String nombre) {

        var param = new ClientPaginationDTO(offset, limit, nombre, null, null);
        return this.clienteService.getList(param);
    }

    @GetMapping("/{id}")
    public Result<ClienteInfoDTO> getClientById(@PathVariable("id") int id) {
        return this.clienteService.getById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Result<ClienteInfoDTO>> createBanco(@Valid @RequestBody ClienteCreateDTO cliente)
            throws Exception {

        var result = this.clienteService.create(cliente);
        return new ResponseEntity<Result<ClienteInfoDTO>>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public Result<String> deleteClientById(@PathVariable("id") Integer id) {
        return this.clienteService.delete(id);
    }

    @PatchMapping("/{id}")
    public Result<ClienteInfoDTO> updateClient(@PathVariable Integer id,
            @Valid @RequestBody ClienteUpdateDTO cliente) {
        return this.clienteService.update(cliente.copyWith(id));
    }

}
