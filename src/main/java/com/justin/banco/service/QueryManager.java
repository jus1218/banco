package com.justin.banco.service;

import java.lang.reflect.Field;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.justin.banco.constants.ResultCodeDB;

import java.util.ArrayList;

import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class QueryManager {

    private Integer positionResultCode = 2;
    public Integer resultCode = ResultCodeDB.PROCEDURE_NOT_EXECUTED;
    @Autowired
    private ObjectMapper objectMapper;

    // Actualizar y crear
    public <T> void executeCreateOrUpdateProcedure(StoredProcedureQuery query, Object instance) {

        var fields = getInstanceAttributeArray(instance);

        try {
            registerParameters(query, fields, instance, true);
            query.execute();
            resultCode = (Integer) query.getOutputParameterValue(positionResultCode);

        } catch (IllegalArgumentException | IllegalAccessException e) {

        }

    }

    // sirve para eliminar
    public <T, N> void executeDeleteProcedure(N index, StoredProcedureQuery query) {

        registerParameter(query, index);

        query.execute();
        resultCode = (Integer) query.getOutputParameterValue(positionResultCode);

    }

    // Buscar
    public <T, N> List<T> executeProcedureAndGetResults(N index, StoredProcedureQuery query) {
        positionResultCode = 2;

        registerParameter(query, index);
        query.execute();

        resultCode = (Integer) query.getOutputParameterValue(positionResultCode);

        if (!ResultCodeDB.isSuccessResultCode(resultCode))
            return new ArrayList<T>();

        var results = query.getResultList();
        @SuppressWarnings("unchecked")
        var result = (T) results.get(0);
        var entities = new ArrayList<T>();
        entities.add(result);

        return entities;
    }

    public <N> void registerParameter(StoredProcedureQuery query, N id) {
        positionResultCode = 2;
        query.registerStoredProcedureParameter(1, id.getClass(), ParameterMode.IN);
        query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.OUT);
        query.setParameter(1, id);

    }

    private void registerParameters(StoredProcedureQuery query, Field[] fields, Object instance, Boolean hasResultCode)
            throws IllegalArgumentException, IllegalAccessException {

        int i = 0;
        if (fields != null) {
            i = 1;
            for (var field : fields) {

                field.setAccessible(true);// permitimos el acceso a los campos
                Class<?> fieldType = field.getType();

                Object valor = field.get(instance);

                query.registerStoredProcedureParameter(i, fieldType, ParameterMode.IN);
                query.setParameter(i, valor);
                i++;

            }
        }

        positionResultCode = i;

        if (hasResultCode)
            query.registerStoredProcedureParameter(positionResultCode, Integer.class, ParameterMode.OUT);

    }

    public Field[] getInstanceAttributeArray(Object instance) {

        if (instance == null)
            return null;
        Class<?> clazz = instance.getClass();
        // Obtener todos los campos de la clase (incluyendo los privados)
        return clazz.getDeclaredFields();
    }

    public <T> T executeProcedureAndGetResult(StoredProcedureQuery query, Object instance) {

        var fields = getInstanceAttributeArray(instance);

        try {
            registerParameters(query, fields, instance, true);
            boolean hasResults = query.execute();
            resultCode = (Integer) query.getOutputParameterValue(positionResultCode);

            if (!ResultCodeDB.isSuccessResultCode(resultCode))
                return null;
            if (!hasResults)
                return null;

            var results = query.getResultList();
            @SuppressWarnings("unchecked")
            var entity = (T) results.get(0);

            return entity;

        } catch (IllegalArgumentException | IllegalAccessException e) {
            // resultCode = -1;
            // message = Message.I_LLEGAL_ACCESS_EXCEPTION;
        }
        return null;
    }

    public <T> List<T> executeProcedureAndReturnASJson(StoredProcedureQuery query, Object instance, Class<T> clazz) {
        try {
            var fields = getInstanceAttributeArray(instance);
            var str = new StringBuilder();

            registerParameters(query, fields, instance, true);

            boolean hasResults = query.execute();
            if (!hasResults)
                return null;

            var results = query.getResultList();

            if (results.isEmpty()) {
                return new ArrayList<T>();
            }

            // var jsonResult = results.get(0).toString();
            resultCode = (Integer) query.getOutputParameterValue(positionResultCode);

            for (int i = 0; i < results.size(); i++) {
                var jsonResult = results.get(i).toString();
                str.append(jsonResult);
            }

            // JsonNode jsonNode = objectMapper.readTree(jsonResult.toString());
            JsonNode jsonNode = objectMapper.readTree(str.toString());

            // Crear TypeReference usando clazz
            List<T> entities = objectMapper.readValue(jsonNode.toString(),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));

            return entities;

        } catch (IllegalAccessException | IllegalArgumentException e) {
            resultCode = ResultCodeDB.I_LLEGAL_ACCESS_EXCEPTION;
        } catch (JsonProcessingException e) {
            resultCode = ResultCodeDB.JSON_PROCESSING_EXCEPTION;
        }

        return null;
    }

    public <T, N> List<T> executeProcedureAndReturnASJson2(StoredProcedureQuery query, N id, Class<T> clazz) {
        try {
            // var fields = getInstanceAttributeArray(instance);
            var str = new StringBuilder();

            // registerParameters(query, fields, instance, true);
            registerParameter(query, id);

            boolean hasResults = query.execute();
            resultCode = (Integer) query.getOutputParameterValue(positionResultCode);
            if (!hasResults)
                return null;
                // return new ArrayList<T>();

            var results = query.getResultList();

            if (results.isEmpty()) {
                return new ArrayList<T>();
            }

            // var jsonResult = results.get(0).toString();
            resultCode = (Integer) query.getOutputParameterValue(positionResultCode);

            for (int i = 0; i < results.size(); i++) {
                var jsonResult = results.get(i).toString();
                str.append(jsonResult);
            }

            // JsonNode jsonNode = objectMapper.readTree(jsonResult.toString());
            JsonNode jsonNode = objectMapper.readTree(str.toString());

            // Crear TypeReference usando clazz
            List<T> entities = objectMapper.readValue(jsonNode.toString(),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));

            return entities;

        } catch (JsonProcessingException e) {
            resultCode = ResultCodeDB.JSON_PROCESSING_EXCEPTION;
        }

        return null;
    }

    public <T, N> List<T> executeProcedureAndReturnASJson(StoredProcedureQuery query, Class<T> clazz) {
        try {
            // var fields = getInstanceAttributeArray(instance);
            var str = new StringBuilder();

            // registerParameters(query, fields, instance, true);
            // registerParameter(query, id);
            query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.OUT);

            boolean hasResults = query.execute();
            if (!hasResults)
                return null;

            var results = query.getResultList();

            if (results.isEmpty()) {
                return new ArrayList<T>();
            }

            // var jsonResult = results.get(0).toString();
            resultCode = (Integer) query.getOutputParameterValue(1);

            for (int i = 0; i < results.size(); i++) {
                var jsonResult = results.get(i).toString();
                str.append(jsonResult);
            }

            // JsonNode jsonNode = objectMapper.readTree(jsonResult.toString());
            JsonNode jsonNode = objectMapper.readTree(str.toString());

            // Crear TypeReference usando clazz
            List<T> entities = objectMapper.readValue(jsonNode.toString(),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));

            return entities;

        } catch (JsonProcessingException e) {
            resultCode = ResultCodeDB.JSON_PROCESSING_EXCEPTION;
        }

        return null;
    }

}
