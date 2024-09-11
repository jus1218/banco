package com.justin.banco.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.justin.banco.dto.banco.BancoCreateDTO;
import com.justin.banco.dto.banco.BancoUpdateDTO;
import com.justin.banco.dto.banco.BancoPaginationDTO;
import com.justin.banco.helpers.Result;
import com.justin.banco.models.Banco;
import com.justin.banco.repository.BancoRepository;

@Service
public class BancoService implements CommonService<Banco, BancoCreateDTO, BancoUpdateDTO,BancoPaginationDTO, String> {

    private @Autowired BancoRepository bancoRepository;

    @Override
    public Result<BancoCreateDTO> create(BancoCreateDTO banco){
        return bancoRepository.create(banco);
    }

    @Override
    public Result<String>  delete(String banco) {
        return this.bancoRepository.delete(banco);
    }

    @Override
    public Result<List<Banco>> getAll(BancoPaginationDTO pagination) throws Exception {
        return this.bancoRepository.getAll(pagination);
    }

    @Override
    public Result<List<Banco>> getByName(String index) {
        return this.bancoRepository.getByName(index);

    }

    public List<Map<String, Object>> getBanksInJson(BancoPaginationDTO pagination) throws JsonMappingException, JsonProcessingException {

        return this.bancoRepository.getBanksInJson(pagination);
    }

    @Override
    public Result<BancoUpdateDTO> update(String codigoBanco, BancoUpdateDTO banco)   {
        return this.bancoRepository.update(codigoBanco, banco);
    }

}
