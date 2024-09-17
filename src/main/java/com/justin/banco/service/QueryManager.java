package com.justin.banco.service;

import java.lang.reflect.Field;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.justin.banco.constants.Message;
import com.justin.banco.constants.ResultCodeDB;

import java.util.ArrayList;

import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class QueryManager {

    public Message message;
    private Integer positionResultCode = 2;
    public Integer resultCode = -1;
    @Autowired
    private MessageManager messageManager;
    @Autowired
    private ObjectMapper objectMapper;

    // Actualizar y crear
    public <T> void executeCreateOrUpdateProcedure(StoredProcedureQuery query, Object instance, Class<T> type) {

        var fields = getInstanceAttributeArray(instance);

        try {
            registerParameters(query, fields, instance, true);
            query.execute();
            resultCode = (int) query.getOutputParameterValue(positionResultCode);
            message = messageManager.<T>getMessageByCode(resultCode, type);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            resultCode = -1;
            message = Message.FAILURE;
        }

    }

    // sirve para eliminar
    public <T, N> void executeDeleteProcedure(N index, StoredProcedureQuery query, Class<T> type) {

        registerParameter(query, index);

        query.execute();
        resultCode = (int) query.getOutputParameterValue(positionResultCode);
        message = messageManager.<T>getMessageByCode(resultCode, type);

    }

    // Buscar
    public <T, N> List<T> executeProcedureAndGetResults(N index, StoredProcedureQuery query, Class<T> type) {
        positionResultCode = 2;

        registerParameter(query, index);
        query.execute();

        resultCode = (int) query.getOutputParameterValue(positionResultCode);
        message = messageManager.<T>getMessageByCode(resultCode, type);

        if (resultCode != ResultCodeDB.SUCCESS) {
            return new ArrayList<T>();
        }

        var results = query.getResultList();
        @SuppressWarnings("unchecked")
        var result = (T) results.get(0);
        var entities = new ArrayList<T>();
        entities.add(result);

        return entities;
    }

    public <N> void registerParameter(StoredProcedureQuery query, N id) {
        positionResultCode=2;
        query.registerStoredProcedureParameter(1, id.getClass(), ParameterMode.IN);
        query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.OUT);
        query.setParameter(1, id);

    }

    private void registerParameters(StoredProcedureQuery query, Field[] fields, Object instance, Boolean hasResultCode)
            throws IllegalArgumentException, IllegalAccessException {

        int i = 1;
        for (var field : fields) {

            field.setAccessible(true);// permitimos el acceso a los campos
            Class<?> fieldType = field.getType();

            Object valor = field.get(instance);

            query.registerStoredProcedureParameter(i, fieldType, ParameterMode.IN);
            query.setParameter(i, valor);
            i++;

        }

        positionResultCode = i;

        if (hasResultCode)
            query.registerStoredProcedureParameter(positionResultCode, Integer.class, ParameterMode.OUT);

    }

    public Field[] getInstanceAttributeArray(Object instance) {
        Class<?> clazz = instance.getClass();
        // Obtener todos los campos de la clase (incluyendo los privados)
        return clazz.getDeclaredFields();
    }

    public <T> List<Map<String, Object>> executeProcedureAndReturnJson(StoredProcedureQuery query, Object instance,
            Class<T> type) {
        try {
            var fields = getInstanceAttributeArray(instance);

            registerParameters(query, fields, instance, false);

            boolean hasResults = query.execute();
            var results = query.getResultList();// puede retorna una exception si no trae nada

            if (results.isEmpty()) {

                return objectMapper.readValue("[]", new TypeReference<List<Map<String, Object>>>() {
                });

            }

            String jsonResult = (String) results.get(0);

            // Procesar el JSON
            JsonNode jsonNode;

            jsonNode = objectMapper.readTree(jsonResult);

            // Convertir JsonNode a List<Map<String, Object>>
            List<Map<String, Object>> entities = objectMapper.readValue(jsonNode.toString(),
                    new TypeReference<List<Map<String, Object>>>() {
                    });

            return entities;

        } catch (IllegalAccessException | IllegalArgumentException e) {
            resultCode = -1;
            message = Message.I_LLEGAL_ACCESS_EXCEPTION;
        } catch (JsonProcessingException e) {
            resultCode = -1;
            message = Message.JSON_PROCESSING_EXCEPTION;
        }

        return null;
    }

    public <T, N> T executeProcedureAndGetResult(StoredProcedureQuery query, Object instance, Class<T> type) {

        var fields = getInstanceAttributeArray(instance);

        try {
            registerParameters(query, fields, instance, true);
            boolean hasResults = query.execute();
            resultCode = (int) query.getOutputParameterValue(positionResultCode);
            message = messageManager.<T>getMessageByCode(resultCode, type);

            if (resultCode != ResultCodeDB.SUCCESS) return null;
            if (!hasResults) return null;

            var results = query.getResultList();
            @SuppressWarnings("unchecked")
            var entity = (T) results.get(0);
            return entity;

        } catch (IllegalArgumentException | IllegalAccessException e) {
            resultCode = -1;
            message = Message.I_LLEGAL_ACCESS_EXCEPTION;
        }
        return null;
    }
}
