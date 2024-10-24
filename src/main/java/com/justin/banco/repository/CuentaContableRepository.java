package com.justin.banco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.justin.banco.dto.cuentacontable.*;
import com.justin.banco.helpers.Result;
import com.justin.banco.models.Banco;
import com.justin.banco.models.CuentaContable;
import com.justin.banco.service.MessageManager;
import com.justin.banco.service.QueryManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

@Repository
public class CuentaContableRepository implements
        CommonRepository<CuentaContable, CuentaContableInfoDTO, CuentaContableCreateDTO, CuentaContableUpdateDTO, CuentaContablePaginationDTO, Long> {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private QueryManager queryManager;

    @Autowired
    private MessageManager messageManager;

    @Override
    public Result<CuentaContableInfoDTO> create(CuentaContableCreateDTO entity) {
        var query = entityManager.createStoredProcedureQuery("SP_C_LedgerAccount", CuentaContableInfoDTO.class);
        var newCurrencyDTO = queryManager.<CuentaContableInfoDTO>executeProcedureAndGetResult(query, entity);

        var message = messageManager.getMessageByCode(queryManager.resultCode, CuentaContable.class);

        return Result.get(newCurrencyDTO, message, queryManager.resultCode);
    }

    @Override
    public Result<CuentaContableInfoDTO> update(CuentaContableUpdateDTO entity) {
        var query = entityManager.createStoredProcedureQuery("SP_U_LeagerAccount", CuentaContableInfoDTO.class);
        var updatedLeagerAccount = queryManager.<CuentaContableInfoDTO>executeProcedureAndGetResult(query, entity);
        var message = messageManager.getMessageByCode(queryManager.resultCode, CuentaContable.class);

        return Result.get(updatedLeagerAccount, message, queryManager.resultCode);
    }

    @Override
    public Result<String> delete(Long id) {
        var query = entityManager.createStoredProcedureQuery("SP_D_LeagerAccount", CuentaContableInfoDTO.class);

        queryManager.executeDeleteProcedure(id, query);
        var message = messageManager.getMessageByCode(queryManager.resultCode, CuentaContable.class);
        return Result.get(null, message, queryManager.resultCode);
    }

    @Override
    public Result<List<CuentaContable>> getList(CuentaContablePaginationDTO entity) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_G_LeagerAccount");
        List<CuentaContable> clientes = queryManager.<CuentaContable>executeProcedureAndReturnASJson(query, entity,
                CuentaContable.class);
        var message = messageManager.getMessageByCode(queryManager.resultCode, CuentaContable.class);
        return Result.get(clientes, message, queryManager.resultCode);
    }

    @Override
    public Result<CuentaContableInfoDTO> getById(Long index) {
        var query = entityManager.createStoredProcedureQuery("SP_F_LeagerAccount", CuentaContableInfoDTO.class);
        var cuentas = queryManager.<CuentaContableInfoDTO, Long>executeProcedureAndGetResults(index, query);
        var message = messageManager.getMessageByCode(queryManager.resultCode, CuentaContable.class);

        return Result.get(
                cuentas.isEmpty()
                        ? null
                        : cuentas.get(0),
                message, queryManager.resultCode);
    }

}
