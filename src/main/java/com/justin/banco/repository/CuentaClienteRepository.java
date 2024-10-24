package com.justin.banco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.justin.banco.dto.cuentacliente.*;
import com.justin.banco.helpers.Result; 
import com.justin.banco.models.CuentaCliente;
import com.justin.banco.models.Selector;
import com.justin.banco.service.MessageManager;
import com.justin.banco.service.QueryManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CuentaClienteRepository implements
        CommonRepository<CuentaCliente, CuentaClienteInfoDTO, CuentaClienteCreateDTO, CuentaClienteUpdateDTO, CuentaClientePaginacionDTO, Long> {

    private @PersistenceContext EntityManager entityManager;

    private @Autowired QueryManager queryManager;

    private @Autowired MessageManager messageManager;

    public Result<List<CuentaCliente>> getList(CuentaClientePaginacionDTO pagination) {

        var query = entityManager.createStoredProcedureQuery("SP_G_Client_account");
        List<CuentaCliente> cuentasClientes = queryManager.<CuentaCliente>executeProcedureAndReturnASJson(query,
                pagination,
                CuentaCliente.class);
        var message = messageManager.getMessageByCode(queryManager.resultCode, CuentaCliente.class);

        return Result.get(cuentasClientes, message, queryManager.resultCode);
    }

    public Result<Selector> getDataSelectores() {

        var query = entityManager.createStoredProcedureQuery("SP_G_DataSelectors");
        List<Selector> selector = queryManager.<Selector>executeProcedureAndReturnASJson(query, null,
                Selector.class);
        var message = messageManager.getMessageByCode(queryManager.resultCode, CuentaCliente.class);

        return Result.get(selector.get(0), message, queryManager.resultCode);
    }

    @Override
    public Result<CuentaClienteInfoDTO> create(CuentaClienteCreateDTO entity) {
        var query = entityManager.createStoredProcedureQuery("SP_C_ClientAccount", CuentaClienteInfoDTO.class);
        var newCurrencyDTO = queryManager.<CuentaClienteInfoDTO>executeProcedureAndGetResult(query, entity);
        var message = messageManager.getMessageByCode(queryManager.resultCode, CuentaCliente.class);

        return Result.get(newCurrencyDTO, message, queryManager.resultCode);
    }

    @Override
    public Result<CuentaClienteInfoDTO> update(CuentaClienteUpdateDTO entity) {
        var query = entityManager.createStoredProcedureQuery("SP_U_ClientAccount", CuentaClienteInfoDTO.class);
        var updatedClient = queryManager.<CuentaClienteInfoDTO>executeProcedureAndGetResult(query, entity);
        var message = messageManager.getMessageByCode(queryManager.resultCode, CuentaCliente.class);

        return Result.get(updatedClient, message, queryManager.resultCode);
    }

    @Override
    public Result<String> delete(Long id) {

        var query = entityManager.createStoredProcedureQuery("SP_D_ClientAccount");
        queryManager.executeDeleteProcedure(id, query);
        var message = messageManager.getMessageByCode(queryManager.resultCode, CuentaCliente.class);
        return Result.get(null, message, queryManager.resultCode);
    }

    @Override
    public Result<CuentaClienteInfoDTO> getById(Long index) {
        var query = entityManager.createStoredProcedureQuery("SP_F_ClientAccount", CuentaClienteInfoDTO.class);

        var clientes = queryManager.<CuentaClienteInfoDTO, Long>executeProcedureAndGetResults(index, query);
        var message = messageManager.getMessageByCode(queryManager.resultCode, CuentaCliente.class);

        return Result.get(
                clientes.isEmpty() ? null : clientes.get(0),
                message, queryManager.resultCode);
    }

}
