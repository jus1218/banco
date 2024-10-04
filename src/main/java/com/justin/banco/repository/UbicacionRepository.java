package com.justin.banco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.justin.banco.helpers.Result;
import com.justin.banco.models.Provincia; 
import com.justin.banco.service.MessageManager;
import com.justin.banco.service.QueryManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

@Repository
public class UbicacionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private QueryManager queryManager;

    @Autowired
    private MessageManager messageManager;

    public Result<List<Provincia>> getProvinciasCantonesDistritos(){

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_G_ProvinciasCantonesDistritos");// ,Banco.class
        List<Provincia> provincias = queryManager.executeProcedureAndReturnASJson(query, Provincia.class);
        var message = messageManager.getMessageByCode(queryManager.resultCode, Provincia.class);
        return Result.get(provincias, message, queryManager.resultCode);

    }

}
