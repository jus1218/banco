package com.justin.banco.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.justin.banco.dto.cliente.ClientPaginationDTO;
import com.justin.banco.dto.cliente.ClienteCreateDTO;
import com.justin.banco.dto.cliente.ClienteUpdateDTO;
import com.justin.banco.helpers.Result;
import com.justin.banco.models.Cliente;
import com.justin.banco.repository.ClienteRepository;

@Service
public class ClienteService
        implements CommonService<Cliente, ClienteCreateDTO, ClienteUpdateDTO, ClientPaginationDTO, Integer> {

    private @Autowired ClienteRepository clienteRepository;

    @Override
    public Result<ClienteCreateDTO> create(ClienteCreateDTO entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Result<ClienteUpdateDTO> update(Integer index, ClienteUpdateDTO entity) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Result<String> delete(Integer code) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Result<List<Cliente>> getAll(ClientPaginationDTO entity) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public List<Map<String, Object>> getBanksInJson(ClientPaginationDTO clientePaginacion) throws JsonMappingException, JsonProcessingException   {
        return this.clienteRepository.getBanksInJson(clientePaginacion);
    }

    @Override
    public Result<List<Cliente>> getByName(Integer index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }

}
