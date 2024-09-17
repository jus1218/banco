package com.justin.banco.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.justin.banco.dto.moneda.MonedaCreateDTO;
import com.justin.banco.dto.moneda.MonedaPaginationDTO;
import com.justin.banco.dto.moneda.MonedaUpdateDTO;
import com.justin.banco.helpers.Result;
import com.justin.banco.helpers.mappers.MonedaMapper;
import com.justin.banco.models.Moneda;
import com.justin.banco.service.QueryManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class MonedaRepository
        implements CommonRepository<Moneda, MonedaCreateDTO, MonedaUpdateDTO, MonedaPaginationDTO, String> {

    private @PersistenceContext EntityManager entityManager;

    private @Autowired QueryManager queryManager;

    @Override
    public Result<MonedaCreateDTO> create(MonedaCreateDTO entity) {
        var query = entityManager.createStoredProcedureQuery("SP_C_Currency", Moneda.class);
        var newCurrency = queryManager.executeProcedureAndGetResult(query, entity, Moneda.class);

        var newCurrencyDTO = MonedaMapper.toCreateCurrencyDTO(newCurrency);

        return Result.get(newCurrencyDTO, queryManager.message, queryManager.resultCode);
    }

    @Override
    public Result<MonedaUpdateDTO> update(MonedaUpdateDTO entity) {
        var query = entityManager.createStoredProcedureQuery("SP_U_Currency", Moneda.class);

        var moneda = queryManager.executeProcedureAndGetResult(query, entity, Moneda.class);

        var updatedCurrencyDTO = MonedaMapper.toUpdateCurrencyDTO(moneda);

        return Result.get(updatedCurrencyDTO, queryManager.message, queryManager.resultCode);
    }

    @Override
    public Result<String> delete(String item) {

        var query = entityManager.createStoredProcedureQuery("SP_D_Currency");

        queryManager.executeDeleteProcedure(item,query,Moneda.class);

        return Result.get(null, queryManager.message, queryManager.resultCode);
    }

    @Override
    public Result<List<Moneda>> getAll(MonedaPaginationDTO entity) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public List<Map<String, Object>> getBanksInJson(MonedaPaginationDTO entity) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBanksInJson'");
    }

    @Override
    public Result<List<Moneda>> getByIdInList(String index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByIdInList'");
    }

    @Override
    public Result<Moneda> getById(String index) {

        var query = entityManager.createStoredProcedureQuery("SP_F_CurrencyById", Moneda.class);

        var monedas = queryManager.executeProcedureAndGetResults(index, query, Moneda.class);

        return Result.get(monedas.isEmpty() ? null : monedas.get(0), queryManager.message, queryManager.resultCode);
    }

}
