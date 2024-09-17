package com.justin.banco.repository;

import java.util.List;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
import com.justin.banco.dto.cliente.*;
import com.justin.banco.helpers.Result; 
import com.justin.banco.models.Cliente;
import com.justin.banco.service.QueryManager;

@Repository
public class ClienteRepository
        implements CommonRepository<Cliente, ClienteCreateDTO, ClienteUpdateDTO, ClientPaginationDTO, Integer> {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private QueryManager queryManager;

    @Override
    public Result<ClienteCreateDTO> create(ClienteCreateDTO cliente) {

        var query = entityManager.createStoredProcedureQuery("SP_C_Client");

        queryManager.executeCreateOrUpdateProcedure(query, cliente, Cliente.class);

        return Result.get(cliente, queryManager.message, queryManager.resultCode);
    }

    @Override
    public Result<ClienteUpdateDTO> update(ClienteUpdateDTO entity) {
        var query = entityManager.createStoredProcedureQuery("SP_U_Client");
        queryManager.executeCreateOrUpdateProcedure(query,entity,Cliente.class);

        return Result.get(entity, queryManager.message, queryManager.resultCode);
    }

    @Override
    public Result<String> delete(Integer id) {
        var query = entityManager.createStoredProcedureQuery("SP_D_ClientByCode");
        queryManager.executeDeleteProcedure(id, query, Cliente.class);
        return Result.get(null, queryManager.message, queryManager.resultCode);
    }

    @Override
    public Result<List<Cliente>> getAll(ClientPaginationDTO entity) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public List<Map<String, Object>> getBanksInJson(ClientPaginationDTO clientePaginacioDTO) {

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_G_ClientInJson");
        return queryManager.executeProcedureAndReturnJson(query, clientePaginacioDTO, Cliente.class);
    }

    @Override
    public Result<List<Cliente>> getByIdInList(Integer index) {

        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public Result<Cliente> getById(Integer index) {
        var query = entityManager.createStoredProcedureQuery("SP_F_ClientByCode", Cliente.class);

        var clientes = queryManager.executeProcedureAndGetResults(index, query, Cliente.class);

        return Result.get(
                clientes.isEmpty() ? null : clientes.get(0),
                queryManager.message, queryManager.resultCode);
    }

}
