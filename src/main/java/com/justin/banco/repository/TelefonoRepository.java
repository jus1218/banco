package com.justin.banco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.justin.banco.dto.telefono.TelefonoCreateDTO;
import com.justin.banco.dto.telefono.TelefonoInfoDTO;
import com.justin.banco.helpers.Result;
import com.justin.banco.models.Telefono;
import com.justin.banco.service.MessageManager;
import com.justin.banco.service.QueryManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

@Repository
public class TelefonoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private QueryManager queryManager;

    @Autowired
    private MessageManager messageManager;

    public Result<TelefonoInfoDTO> create(TelefonoCreateDTO telefono) {

        var query = entityManager.createStoredProcedureQuery("SP_C_Phone", TelefonoInfoDTO.class);
        var newBank = queryManager.<TelefonoInfoDTO>executeProcedureAndGetResult(query, telefono);
        var message = messageManager.getMessageByCode(queryManager.resultCode, Telefono.class);

        return Result.get(newBank, message, queryManager.resultCode);
    }

    public Result<String> delete(String numeroTelefono) {
        var query = entityManager.createStoredProcedureQuery("SP_D_Phone");
        queryManager.executeDeleteProcedure(numeroTelefono, query);
        var message = messageManager.getMessageByCode(queryManager.resultCode, Telefono.class);
        return Result.get(null, message, queryManager.resultCode);
    }

    public Result<List<Telefono>> getPhonesByCodeClient(Integer id) {

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_G_PhonesByCodeClient");// ,Banco.class
        List<Telefono> telefonos = queryManager.executeProcedureAndReturnASJson2(query, id, Telefono.class);
        var message = messageManager.getMessageByCode(queryManager.resultCode, Telefono.class);
        return Result.get(telefonos, message, queryManager.resultCode);

    }

}
