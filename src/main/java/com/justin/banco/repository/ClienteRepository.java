package com.justin.banco.repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.justin.banco.dto.banco.BancoInfoDTO;
import com.justin.banco.dto.cliente.*;
import com.justin.banco.helpers.Result;
import com.justin.banco.models.Cliente;
import com.justin.banco.models.Moneda;
import com.justin.banco.service.MessageManager;
import com.justin.banco.service.QueryManager;

@Repository
public class ClienteRepository
        implements
        CommonRepository<Cliente, ClienteInfoDTO, ClienteCreateDTO, ClienteUpdateDTO, ClientPaginationDTO, Integer> {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private QueryManager queryManager;

    @Autowired
    private MessageManager messageManager;

    @Override
    public Result<ClienteInfoDTO> create(ClienteCreateDTO cliente) {

        var query = entityManager.createStoredProcedureQuery("SP_C_Client", ClienteInfoDTO.class);

        var newClient = queryManager.<ClienteInfoDTO>executeProcedureAndGetResult(query, cliente);
        var message = messageManager.getMessageByCode(queryManager.resultCode, ClienteInfoDTO.class);

        return Result.get(newClient, message, queryManager.resultCode);
    }

    @Override
    public Result<ClienteInfoDTO> update(ClienteUpdateDTO entity) {
        var query = entityManager.createStoredProcedureQuery("SP_U_Client",ClienteInfoDTO.class);
        var updatedClient = queryManager.<ClienteInfoDTO>executeProcedureAndGetResult(query, entity);
        var message = messageManager.getMessageByCode(queryManager.resultCode, ClienteInfoDTO.class);

        return Result.get(updatedClient, message, queryManager.resultCode);
    }

    @Override
    public Result<String> delete(Integer id) {
        var query = entityManager.createStoredProcedureQuery("SP_D_ClientByCode");
        queryManager.executeDeleteProcedure(id, query);
        var message = messageManager.getMessageByCode(queryManager.resultCode, ClienteInfoDTO.class);
        return Result.get(null, message, queryManager.resultCode);
    }

    @Override
    public Result<List<Cliente>> getBanksInJson(ClientPaginationDTO clientePaginacioDTO) {

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_G_ClientInJson");
        List<Cliente> clientes = queryManager.<Cliente>executeProcedureAndReturnASJson(query, clientePaginacioDTO,
                Cliente.class);
        var message = messageManager.getMessageByCode(queryManager.resultCode, ClienteInfoDTO.class);
        return Result.get(clientes, message, queryManager.resultCode);
    }

    @Override
    public Result<ClienteInfoDTO> getById(Integer index) {
        var query = entityManager.createStoredProcedureQuery("SP_F_ClientByCode", ClienteInfoDTO.class);

        var clientes = queryManager.<ClienteInfoDTO, Integer>executeProcedureAndGetResults(index, query);
        var message = messageManager.getMessageByCode(queryManager.resultCode, ClienteInfoDTO.class);

        return Result.get(
                clientes.isEmpty() ? null : clientes.get(0),
                message, queryManager.resultCode);
    }

}
