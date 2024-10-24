package com.justin.banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justin.banco.dto.cliente.ClientPaginationDTO;
import com.justin.banco.dto.cliente.ClienteCreateDTO;
import com.justin.banco.dto.cliente.ClienteInfoDTO;
import com.justin.banco.dto.cliente.ClienteUpdateDTO;
import com.justin.banco.helpers.Result;
import com.justin.banco.models.Cliente;
import com.justin.banco.repository.ClienteRepository;

@Service
public class ClienteService
        implements
        CommonService<Cliente, ClienteInfoDTO, ClienteCreateDTO, ClienteUpdateDTO, ClientPaginationDTO, Integer> {

    private @Autowired ClienteRepository clienteRepository;

    @Override
    public Result<ClienteInfoDTO> create(ClienteCreateDTO entity) {
        return this.clienteRepository.create(entity);
    }

    @Override
    public Result<ClienteInfoDTO> update(ClienteUpdateDTO cliente) {
        return this.clienteRepository.update(cliente);
    }

    @Override
    public Result<String> delete(Integer code) {
        return this.clienteRepository.delete(code);
    }

    @Override
    public  Result<List<Cliente>>  getList(ClientPaginationDTO clientePaginacion) {
        return this.clienteRepository.getList(clientePaginacion);
    }

    @Override
    public Result<ClienteInfoDTO> getById(Integer index) {
        return this.clienteRepository.getById(index);
    }

}
