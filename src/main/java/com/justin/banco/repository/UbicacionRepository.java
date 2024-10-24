package com.justin.banco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.justin.banco.dto.Ubicacion.*;
import com.justin.banco.dto.tipocambio.TipoCambioInfoDTO;
import com.justin.banco.helpers.Result;
import com.justin.banco.models.Provincia;
import com.justin.banco.models.TipoCambio;
import com.justin.banco.models.Ubicacion;
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

    public Result<List<Provincia>> getProvinciasCantonesDistritos() {

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_G_ProvinciasCantonesDistritos");// ,Banco.class
        List<Provincia> provincias = queryManager.executeProcedureAndReturnASJson(query, Provincia.class);
        var message = messageManager.getMessageByCode(queryManager.resultCode, Provincia.class);
        return Result.get(provincias, message, queryManager.resultCode);

    }

    public <T> Result<UbicacionInfoDTO> createProvince(UbicationCreateDTO entity, Class<T> type) {
        var query = entityManager.createStoredProcedureQuery("SP_C_Ubication", UbicacionInfoDTO.class);
        var newCurrencyDTO = queryManager.<UbicacionInfoDTO>executeProcedureAndGetResult(query, entity);
        var message = messageManager.getMessageByCode(queryManager.resultCode, Ubicacion.class);
        return Result.get(newCurrencyDTO, message, queryManager.resultCode);

    }

    public Result<UbicacionInfoDTO> getUbication(Ubicacion ubicacion) {

        var query = entityManager.createStoredProcedureQuery("SP_F_Ubication", UbicacionInfoDTO.class);

        var tipoCambio = queryManager.<UbicacionInfoDTO>executeProcedureAndGetResult(query, ubicacion);
        var message = messageManager.getMessageByCode(queryManager.resultCode,
                Ubicacion.class);

        return Result.get(tipoCambio, message, queryManager.resultCode);

    }

    public Result<List<ProvinciaDetailDTO>> getProvincies(ProvinciaPaginationDTO pagination) {

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_G_Provincias");
        List<ProvinciaDetailDTO> clientes = queryManager.<ProvinciaDetailDTO>executeProcedureAndReturnASJson(query,
                pagination,
                ProvinciaDetailDTO.class);
        var message = messageManager.getMessageByCode(queryManager.resultCode, Ubicacion.class);
        return Result.get(clientes, message, queryManager.resultCode);
    }

    public Result<Provincia> getProvincie(Integer code) {

        var query = entityManager.createStoredProcedureQuery("SP_F_Provincia");
        var provincias = queryManager.<Provincia, Integer>executeProcedureAndReturnASJson2(query, code,
                Provincia.class);
        var message = messageManager.getMessageByCode(queryManager.resultCode, Ubicacion.class);

        if (provincias != null) {
            return Result.get(provincias.isEmpty() ? null : provincias.get(0), message, queryManager.resultCode);
        }

        return Result.get(null, message, queryManager.resultCode);
    }

    public Result<UbicacionInfoDTO> updateUbication(UbicationUpdatedDTO ubication) {

        var query = entityManager.createStoredProcedureQuery("SP_U_Ubication", UbicacionInfoDTO.class);

        var ubicationUpdated = queryManager.<UbicacionInfoDTO>executeProcedureAndGetResult(query, ubication);

        var message = messageManager.getMessageByCode(queryManager.resultCode, Ubicacion.class);

        return Result.get(ubicationUpdated, message, queryManager.resultCode);

    }
    

    public Result<UbicacionInfoDTO> deleteUbicationById(UbicationDeleteDTO ubicationDelete) {

        var query = entityManager.createStoredProcedureQuery("SP_D_Ubication", UbicacionInfoDTO.class);
        var tipoCambio = queryManager.<UbicacionInfoDTO>executeProcedureAndGetResult(query, ubicationDelete);
        var message = messageManager.getMessageByCode(queryManager.resultCode, Ubicacion.class);

        return Result.get(tipoCambio, message, queryManager.resultCode);
    }

}
