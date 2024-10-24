package com.justin.banco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.justin.banco.dto.Ubicacion.UbicacionInfoDTO;
import com.justin.banco.dto.moneda.MonedaCreateDTO;
import com.justin.banco.dto.moneda.MonedaPaginationDTO;
import com.justin.banco.dto.moneda.MonedaUpdateDTO;
import com.justin.banco.dto.moneda.MonedaInfoDTO;
import com.justin.banco.helpers.Result;
import com.justin.banco.models.Banco;
import com.justin.banco.models.Moneda;
import com.justin.banco.models.Ubicacion;
import com.justin.banco.service.MessageManager;
import com.justin.banco.service.QueryManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class MonedaRepository
        implements
        CommonRepository<Moneda, MonedaInfoDTO, MonedaCreateDTO, MonedaUpdateDTO, MonedaPaginationDTO, String> {

    private @PersistenceContext EntityManager entityManager;

    private @Autowired QueryManager queryManager;

    private @Autowired MessageManager messageManager;

    @Override
    public Result<MonedaInfoDTO> create(MonedaCreateDTO entity) {
        var query = entityManager.createStoredProcedureQuery("SP_C_Currency", MonedaInfoDTO.class);
        var newCurrencyDTO = queryManager.<MonedaInfoDTO>executeProcedureAndGetResult(query, entity);

        var message = messageManager.getMessageByCode(queryManager.resultCode, Moneda.class);

        return Result.get(newCurrencyDTO, message, queryManager.resultCode);
    }

    @Override
    public Result<MonedaInfoDTO> update(MonedaUpdateDTO entity) {
        var query = entityManager.createStoredProcedureQuery("SP_U_Currency", MonedaInfoDTO.class);

        var updatedCurrencyDTO = queryManager.<MonedaInfoDTO>executeProcedureAndGetResult(query, entity);

        var message = messageManager.getMessageByCode(queryManager.resultCode, Moneda.class);

        return Result.get(updatedCurrencyDTO, message, queryManager.resultCode);
    }

    @Override
    public Result<String> delete(String item) {

        var query = entityManager.createStoredProcedureQuery("SP_D_Currency");
        queryManager.executeDeleteProcedure(item, query);
        var message = messageManager.getMessageByCode(queryManager.resultCode, Moneda.class);
        return Result.get(null, message, queryManager.resultCode);
    }

    @Override
    public Result<List<Moneda>> getList(MonedaPaginationDTO entity) {

        var query = entityManager.createStoredProcedureQuery("SP_G_CurrencyAsJson");
        List<Moneda> monedas = queryManager.<Moneda>executeProcedureAndReturnASJson(query, entity, Moneda.class);
        var message = messageManager.getMessageByCode(queryManager.resultCode, Moneda.class);

        return Result.get(monedas, message, queryManager.resultCode);
    }

    @Override
    public Result<MonedaInfoDTO> getById(String index) {

        var query = entityManager.createStoredProcedureQuery("SP_F_CurrencyById", MonedaInfoDTO.class);

        var monedas = queryManager.<MonedaInfoDTO, String>executeProcedureAndGetResults(index, query);
        var message = messageManager.getMessageByCode(queryManager.resultCode, Moneda.class);

        return Result.get(monedas.isEmpty() ? null : monedas.get(0), message, queryManager.resultCode);
    }

}
