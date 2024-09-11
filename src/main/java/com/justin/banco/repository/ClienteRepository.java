package com.justin.banco.repository;

import java.util.List;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.justin.banco.dto.cliente.*;
import com.justin.banco.helpers.Result;
import com.justin.banco.models.Cliente;

@Repository
public class ClienteRepository
        implements CommonRepository<Cliente, ClienteCreateDTO, ClienteUpdateDTO, ClientPaginationDTO, Integer> {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private ObjectMapper objectMapper;

    private Integer resultCode = 0;

    private void initializeParameterCreate(StoredProcedureQuery query, ClienteCreateDTO banco) {
        query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(5, Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(6, Integer.class, ParameterMode.OUT);

        // query.setParameter(1, banco.codigoBanco());
        // query.setParameter(2, banco.nombre());
        // query.setParameter(3, banco.direccionExacta());
        // query.setParameter(4, banco.codigoMoneda());
        // query.setParameter(5, banco.codigoDistrito());
        query.setParameter(6, resultCode);
    }

    @Override
    public Result<ClienteCreateDTO> create(ClienteCreateDTO entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Result<ClienteUpdateDTO> update(Integer index, ClienteUpdateDTO entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Result<String> delete(Integer item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Result<List<Cliente>> getAll(ClientPaginationDTO entity) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public List<Map<String, Object>> getBanksInJson(ClientPaginationDTO clientePaginacioDTO)
            throws JsonMappingException, JsonProcessingException {

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_G_ClientInJson");

        query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(4, Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(5, Integer.class, ParameterMode.IN);

        query.setParameter(1, clientePaginacioDTO.offset());
        query.setParameter(2, clientePaginacioDTO.limit());
        query.setParameter(3, clientePaginacioDTO.nombre());
        query.setParameter(4, clientePaginacioDTO.distrito());
        query.setParameter(5, clientePaginacioDTO.cedula());

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
        List<Map<String, Object>> clientes = objectMapper.readValue(jsonNode.toString(),
                new TypeReference<List<Map<String, Object>>>() {
                });

        return clientes;
    }

    @Override
    public Result<List<Cliente>> getByName(Integer index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }

}
