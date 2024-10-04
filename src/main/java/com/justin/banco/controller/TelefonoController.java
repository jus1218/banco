package com.justin.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.justin.banco.dto.telefono.TelefonoCreateDTO;
import com.justin.banco.dto.telefono.TelefonoInfoDTO; 
import com.justin.banco.helpers.Result;
import com.justin.banco.models.Telefono;
import com.justin.banco.service.TelefonoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/telefonos")
public class TelefonoController {

    public @Autowired TelefonoService telefonoService;

    @PostMapping("/create")
    public ResponseEntity<Result<TelefonoInfoDTO>> createPhone(@Valid @RequestBody TelefonoCreateDTO banco) {
        var result = this.telefonoService.create(banco);

        return new ResponseEntity<Result<TelefonoInfoDTO>>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public Result<String> deleteClientById(@PathVariable("id") String id) {
        return this.telefonoService.delete(id);
    }

    @GetMapping("/client/{id}")
    public Result<List<Telefono>> getPhonesByCodeClient(@PathVariable("id") Integer id) {
        return this.telefonoService.getPhonesByCodeClient(id);
    }


}
