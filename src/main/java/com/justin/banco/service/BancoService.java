package com.justin.banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.justin.banco.dto.banco.BancoCreateDTO;
import com.justin.banco.dto.banco.BancoInfoDTO;
import com.justin.banco.dto.banco.BancoUpdateDTO;
import com.justin.banco.dto.banco.BancoPaginationDTO;
import com.justin.banco.helpers.Result;
import com.justin.banco.models.Banco;
import com.justin.banco.models.Telefono;
import com.justin.banco.repository.BancoRepository;

@Service
public class BancoService
        implements CommonService<Banco, BancoInfoDTO, BancoCreateDTO, BancoUpdateDTO, BancoPaginationDTO, String> {

    private @Autowired BancoRepository bancoRepository;

    @Override
    public Result<BancoInfoDTO> create(BancoCreateDTO banco) {
        return bancoRepository.create(banco);
    }

    @Override
    public Result<String> delete(String banco) {
        return this.bancoRepository.delete(banco);
    }

    public Result<List<Banco>> getBanksInJson(BancoPaginationDTO pagination) {

        return this.bancoRepository.getBanksInJson(pagination);
    }

    @Override
    public Result<BancoInfoDTO> update(BancoUpdateDTO banco) {
        return this.bancoRepository.update(banco);
    }

    @Override
    public Result<BancoInfoDTO> getById(String index) {
        return this.bancoRepository.getById(index);
    }

    public Result<List<Telefono>> getPhonesByCodeBank(String codigoBanco) {

        return this.bancoRepository.getPhonesByCodeBank(codigoBanco);
    }

}
