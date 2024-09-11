package com.justin.banco.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.justin.banco.dto.banco.BancoCreateDTO;
import com.justin.banco.dto.banco.BancoUpdateDTO;
import com.justin.banco.dto.banco.BancoPaginationDTO;
import com.justin.banco.helpers.Message;
import com.justin.banco.helpers.Result;
import com.justin.banco.models.Banco;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

@Repository
public class BancoRepository
        implements CommonRepository<Banco, BancoCreateDTO, BancoUpdateDTO, BancoPaginationDTO, String> {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private ObjectMapper objectMapper;

    private Integer resultCode = 0;

    private void initializeParameterCreate(StoredProcedureQuery query, BancoCreateDTO banco) {
        query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(5, Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(6, Integer.class, ParameterMode.OUT);

        query.setParameter(1, banco.codigoBanco());
        query.setParameter(2, banco.nombre());
        query.setParameter(3, banco.direccionExacta());
        query.setParameter(4, banco.codigoMoneda());
        query.setParameter(5, banco.codigoDistrito());
        query.setParameter(6, resultCode);
    }

    private void initializeParameterUpdate(StoredProcedureQuery query,
            BancoUpdateDTO banco, String codigoBanco) {
        query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(5, Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(6, Integer.class, ParameterMode.OUT);

        query.setParameter(1, codigoBanco);
        query.setParameter(2, banco.nombre());
        query.setParameter(3, banco.direccionExacta());
        query.setParameter(4, banco.codigoMoneda());
        query.setParameter(5, banco.codigoDistrito());
        query.setParameter(6, resultCode);
    }

    @Override
    public Result<BancoCreateDTO> create(BancoCreateDTO banco) {
        this.resultCode = 0;

        var query = entityManager.createStoredProcedureQuery("SP_C_CreateBank");
        initializeParameterCreate(query, banco);

        int resultCode = (int) query.getOutputParameterValue(6);
        String message = Message.getBankMessage(resultCode);

        return Result.get(banco, message, resultCode);
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

        return Result.failure("error");

    }

    @Override
    public List<Map<String, Object>> getBanksInJson(BancoPaginationDTO pagination)
            throws JsonMappingException, JsonProcessingException {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_G_BanksInJson");// ,Banco.class

        // ------------------------
        query.registerStoredProcedureParameter(1, int.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(2, int.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        query.setParameter(1, pagination.offset());
        query.setParameter(2, pagination.limit());
        query.setParameter(3, pagination.nombre());
        query.setParameter(4, pagination.district());

        query.execute();

        var results = query.getResultList();

        if (results.isEmpty()) {
            return objectMapper.readValue("[]", new TypeReference<List<Map<String, Object>>>() {
            });
        }

        String jsonResult = (String) results.get(0);

        // Procesar el JSON
        JsonNode jsonNode = objectMapper.readTree(jsonResult);
        // Convertir JsonNode a List<Map<String, Object>>
        List<Map<String, Object>> bancos = objectMapper.readValue(jsonNode.toString(),
                new TypeReference<List<Map<String, Object>>>() {
                });

        return bancos;

    }

    @Override
    public Result<BancoUpdateDTO> update(String codigoBanco, BancoUpdateDTO banco) {

        this.resultCode = 0;
        var query = entityManager.createStoredProcedureQuery("SP_U_UpdateBank");
        initializeParameterUpdate(query, banco, codigoBanco);
        int resultCode = (int) query.getOutputParameterValue(6);
        String message = Message.getBankMessage(resultCode);

        return Result.get(banco.copyWith(codigoBanco), message, resultCode);
    }

    @Override
    public Result<String> delete(String codigoBanco) {
        var result = this.execute(codigoBanco, "SP_D_BankByCode");

        return Result.success(null, result.getMessage());
    }

    @Override
    public Result<List<Banco>> getByName(String nombreBanco) {
        return this.execute(nombreBanco, "SP_F_FindBankByName");
    }

    private Result<List<Banco>> execute(String identificador, String nombreProcedimiento) {

        this.resultCode = 0;
        var query = entityManager.createStoredProcedureQuery(nombreProcedimiento, Banco.class);
        query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.OUT);
        query.setParameter(1, identificador);
        query.execute();

        // Obtener la lista de resultados

        int resultCode = (int) query.getOutputParameterValue(2);
        String message = Message.getBankMessage(resultCode);

        return Result.get(null, message, resultCode);
    }
}
