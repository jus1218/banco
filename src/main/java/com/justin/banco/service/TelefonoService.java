package com.justin.banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.justin.banco.dto.telefono.TelefonoCreateDTO;
import com.justin.banco.dto.telefono.TelefonoInfoDTO;
import com.justin.banco.helpers.Result;
import com.justin.banco.models.Telefono;
import com.justin.banco.repository.TelefonoRepository;

@Service
public class TelefonoService {

    private @Autowired TelefonoRepository telefonoRepositorio;

    public Result<TelefonoInfoDTO> create(TelefonoCreateDTO telefono) {
        return this.telefonoRepositorio.create(telefono);
    }

    public Result<String> delete(String numeroTelefono) {
        return this.telefonoRepositorio.delete(numeroTelefono);
    }

    public Result<List<Telefono>> getPhonesByCodeClient(Integer id) {
        return this.telefonoRepositorio.getPhonesByCodeClient(id);
    }
}
