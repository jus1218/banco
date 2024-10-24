package com.justin.banco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.justin.banco.dto.tipocambio.TipoCambioCreateDTO;
import com.justin.banco.dto.tipocambio.TipoCambioDeleteAndUpdateDTO;
import com.justin.banco.dto.tipocambio.TipoCambioInfoDTO;
import com.justin.banco.dto.tipocambio.TipoCambioPaginationDTO;
import com.justin.banco.dto.tipocambio.TipoCambioUpdateDTO;
import com.justin.banco.helpers.Result;
import com.justin.banco.models.TipoCambio;
import com.justin.banco.service.MessageManager;
import com.justin.banco.service.QueryManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class TipoCambioRepository implements
        CommonRepository<TipoCambio, TipoCambioInfoDTO, TipoCambioCreateDTO, TipoCambioUpdateDTO, TipoCambioPaginationDTO, String>,
        CompositeKeyRepository<TipoCambioDeleteAndUpdateDTO, TipoCambioInfoDTO> {

    private @PersistenceContext EntityManager entityManager;

    private @Autowired QueryManager queryManager;

    private @Autowired MessageManager messageManager;

    @Override
    public Result<TipoCambioInfoDTO> create(TipoCambioCreateDTO entity) {
        var query = entityManager.createStoredProcedureQuery("SP_C_ExchangeRate", TipoCambioInfoDTO.class);
        var newCurrencyDTO = queryManager.<TipoCambioInfoDTO>executeProcedureAndGetResult(query, entity);
        var message = messageManager.getMessageByCode(queryManager.resultCode, TipoCambio.class);

        return Result.get(newCurrencyDTO, message, queryManager.resultCode);
    }

    @Override
    public Result<TipoCambioInfoDTO> update(TipoCambioUpdateDTO entity) {
        var query = entityManager.createStoredProcedureQuery("SP_U_ExchangeRate", TipoCambioInfoDTO.class);

        var updatedCurrencyDTO = queryManager.<TipoCambioInfoDTO>executeProcedureAndGetResult(query, entity);

        var message = messageManager.getMessageByCode(queryManager.resultCode, TipoCambio.class);

        return Result.get(updatedCurrencyDTO, message, queryManager.resultCode);
    }

    @Override
    public Result<String> delete(String item) {
        // var query = entityManager.createStoredProcedureQuery("SP_D_ExchangeRate");

        // queryManager.executeDeleteProcedure(item, query);
        // var message = messageManager.getMessageByCode(queryManager.resultCode,
        // TipoCambio.class);

        // return Result.get(null, message, queryManager.resultCode);

        throw new UnsupportedOperationException("Metodo inexistente.");
    }

    @Override
    public Result<List<TipoCambio>> getList(TipoCambioPaginationDTO entity) {
        var query = entityManager.createStoredProcedureQuery("SP_G_ExchangeRatesInJson");
        List<TipoCambio> monedas = queryManager.<TipoCambio>executeProcedureAndReturnASJson(query, entity,
                TipoCambio.class);
        var message = messageManager.getMessageByCode(queryManager.resultCode, TipoCambio.class);

        return Result.get(monedas, message, queryManager.resultCode);
    }

    @Override
    public Result<TipoCambioInfoDTO> getById(String index) {
        // var query = entityManager.createStoredProcedureQuery("SP_F_CurrencyById",
        // TipoCambioInfoDTO.class);

        // var monedas = queryManager.<TipoCambioInfoDTO,
        // String>executeProcedureAndGetResults(index, query);
        // var message = messageManager.getMessageByCode(queryManager.resultCode,
        // TipoCambioInfoDTO.class);

        // return Result.get(monedas.isEmpty() ? null : monedas.get(0), message,
        // queryManager.resultCode);
        throw new UnsupportedOperationException("Metodo inexistente.");
    }

    @Override
    public Result<TipoCambioInfoDTO> DeleteByCompositePrimaryKey(TipoCambioDeleteAndUpdateDTO entity) {
        var query = entityManager.createStoredProcedureQuery("SP_D_ExchangeRate", TipoCambioInfoDTO.class);
        var tipoCambio = queryManager.<TipoCambioInfoDTO>executeProcedureAndGetResult(query, entity);
        var message = messageManager.getMessageByCode(queryManager.resultCode, TipoCambio.class);

        return Result.get(tipoCambio, message, queryManager.resultCode);

    }

    @Override
    public Result<TipoCambioInfoDTO> getByCompositePrimaryKey(TipoCambioDeleteAndUpdateDTO entity) {

        var query = entityManager.createStoredProcedureQuery("SP_G_ExchangeRate",
                TipoCambioInfoDTO.class);

        var tipoCambio = queryManager.<TipoCambioInfoDTO>executeProcedureAndGetResult(query, entity);
        var message = messageManager.getMessageByCode(queryManager.resultCode,
        TipoCambio.class);

        return Result.get(tipoCambio, message, queryManager.resultCode);

    }

}
