package com.justin.banco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.justin.banco.dto.banco.BancoCreateDTO;
import com.justin.banco.dto.banco.BancoInfoDTO;
import com.justin.banco.dto.banco.BancoUpdateDTO;
import com.justin.banco.dto.banco.BancoPaginationDTO;
import com.justin.banco.helpers.Result;
import com.justin.banco.models.Banco;
import com.justin.banco.models.Telefono;
import com.justin.banco.service.MessageManager;
import com.justin.banco.service.QueryManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

@Repository
public class BancoRepository
        implements CommonRepository<Banco, BancoInfoDTO, BancoCreateDTO, BancoUpdateDTO, BancoPaginationDTO, String> {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private QueryManager queryManager;

    @Autowired
    private MessageManager messageManager;

    @Override
    public Result<BancoInfoDTO> create(BancoCreateDTO banco) {

        var query = entityManager.createStoredProcedureQuery("SP_C_CreateBank", BancoInfoDTO.class);
        var newBank = queryManager.<BancoInfoDTO>executeProcedureAndGetResult(query, banco);
        var message = messageManager.getMessageByCode(queryManager.resultCode, Banco.class);

        return Result.get(newBank, message, queryManager.resultCode);
    }

    @Override
    public Result<List<Banco>> getBanksInJson(BancoPaginationDTO pagination) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_G_BanksInJson");// ,Banco.class
        List<Banco> bancos = queryManager.executeProcedureAndReturnASJson(query, pagination, Banco.class);
        var message = messageManager.getMessageByCode(queryManager.resultCode, Banco.class);
        return Result.get(bancos, message, queryManager.resultCode);

    }

    @Override
    public Result<BancoInfoDTO> update(BancoUpdateDTO banco) {

        var query = entityManager.createStoredProcedureQuery("SP_U_UpdateBank", BancoInfoDTO.class);
        var updatedBank = queryManager.<BancoInfoDTO>executeProcedureAndGetResult(query, banco);
        var message = messageManager.getMessageByCode(queryManager.resultCode, Banco.class);

        return Result.get(updatedBank, message, queryManager.resultCode);
    }

    @Override
    public Result<String> delete(String codigoBanco) {
        var query = entityManager.createStoredProcedureQuery("SP_D_BankByCode");
        queryManager.executeDeleteProcedure(codigoBanco, query);
        var message = messageManager.getMessageByCode(queryManager.resultCode, Banco.class);
        return Result.get(null, message, queryManager.resultCode);

    }

    @Override
    public Result<BancoInfoDTO> getById(String index) {

        var query = entityManager.createStoredProcedureQuery("SP_F_FindBankByCode", BancoInfoDTO.class);
        var bancos = queryManager.<BancoInfoDTO, String>executeProcedureAndGetResults(index, query);
        var message = messageManager.getMessageByCode(queryManager.resultCode, Banco.class);

        return Result.get(
                bancos.isEmpty()
                        ? null
                        : bancos.get(0),
                message, queryManager.resultCode);

    }

    public Result<List<Telefono>> getPhonesByCodeBank(String codigoBanco) {

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_G_PhonesByCodeBank");// ,Banco.class
        List<Telefono> telefonos = queryManager.executeProcedureAndReturnASJson2(query, codigoBanco, Telefono.class);
        var message = messageManager.getMessageByCode(queryManager.resultCode, Telefono.class);
        return Result.get(telefonos, message, queryManager.resultCode);
    }

}
