package com.justin.banco.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.justin.banco.constants.Message;
import com.justin.banco.dto.banco.BancoCreateDTO;
import com.justin.banco.dto.banco.BancoUpdateDTO;
import com.justin.banco.dto.banco.BancoPaginationDTO;
import com.justin.banco.helpers.Result;
import com.justin.banco.models.Banco;
import com.justin.banco.models.Cliente;
import com.justin.banco.models.Moneda;
import com.justin.banco.service.QueryManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

@Repository
public class BancoRepository
        implements CommonRepository<Banco, BancoCreateDTO, BancoUpdateDTO, BancoPaginationDTO, String> {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private QueryManager queryManager;

    @Override
    public Result<BancoCreateDTO> create(BancoCreateDTO banco) {

        var query = entityManager.createStoredProcedureQuery("SP_C_CreateBank");

        queryManager.executeCreateOrUpdateProcedure(query, banco, Banco.class);

        return Result.get(banco, queryManager.message, queryManager.resultCode);
    }

    @Override
    public Result<List<Banco>> getAll(BancoPaginationDTO pagination) throws Exception {

        // StoredProcedureQuery query =
        // entityManager.createStoredProcedureQuery("SP_G_getAllBanks");// ,Banco.class

        // // ------------------------

        // query.execute();

        // // Obtener el resultado como String
        // String jsonResult = (String) query.getSingleResult();

        // // Procesar el JSON
        // JsonNode jsonNode = objectMapper.readTree(jsonResult);
        // // Convertir JsonNode a List<Map<String, Object>>
        // List<Map<String, Object>> bancos =
        // objectMapper.readValue(jsonNode.toString(),
        // new TypeReference<List<Map<String, Object>>>() {
        // });
        // ------------------------

        return Result.failure(Message.EMPTY);

    }

    @Override
    public List<Map<String, Object>> getBanksInJson(BancoPaginationDTO pagination)
            throws JsonMappingException, JsonProcessingException {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_G_BanksInJson");// ,Banco.class

        // return bancos;
        return queryManager.executeProcedureAndReturnJson(query, pagination, Banco.class);

    }

    @Override
    public Result<BancoUpdateDTO> update(BancoUpdateDTO banco) {

        var query = entityManager.createStoredProcedureQuery("SP_U_UpdateBank");
        queryManager.executeCreateOrUpdateProcedure(query, banco, Cliente.class);

        return Result.get(banco, queryManager.message, queryManager.resultCode);
    }

    @Override
    public Result<String> delete(String codigoBanco) {
        var query = entityManager.createStoredProcedureQuery("SP_D_BankByCode");
        queryManager.executeDeleteProcedure(codigoBanco, query, Banco.class);
        return Result.get(null, queryManager.message, queryManager.resultCode);

    }

    @Override
    public Result<List<Banco>> getByIdInList(String codigoBanco) {

        var query = entityManager.createStoredProcedureQuery("SP_F_FindBankByCode", Banco.class);
        var bancos = queryManager.executeProcedureAndGetResults(codigoBanco, query, Banco.class);

        return Result.get(
                bancos.isEmpty()
                        ? null
                        : bancos,
                queryManager.message, queryManager.resultCode);
    }

    @Override
    public Result<Banco> getById(String index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");

    }
}
