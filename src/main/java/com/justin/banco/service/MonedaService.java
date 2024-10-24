package com.justin.banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justin.banco.dto.moneda.MonedaCreateDTO;
import com.justin.banco.dto.moneda.MonedaPaginationDTO;
import com.justin.banco.dto.moneda.MonedaUpdateDTO;
import com.justin.banco.dto.moneda.MonedaInfoDTO;
import com.justin.banco.helpers.Result;
import com.justin.banco.models.Moneda;
import com.justin.banco.repository.MonedaRepository;

@Service
public class MonedaService
        implements CommonService<Moneda, MonedaInfoDTO, MonedaCreateDTO, MonedaUpdateDTO, MonedaPaginationDTO, String> {

    private @Autowired MonedaRepository monedaRepository;

    @Override
    public Result<MonedaInfoDTO> create(MonedaCreateDTO entity) {
        return this.monedaRepository.create(entity);
    }

    @Override
    public Result<MonedaInfoDTO> update(MonedaUpdateDTO entity) {
        return this.monedaRepository.update(entity);
    }

    @Override
    public Result<String> delete(String code) {
        return this.monedaRepository.delete(code);
    }

    @Override
    public Result<List<Moneda>> getList(MonedaPaginationDTO entity) {
        return this.monedaRepository.getList(entity);
    }

    @Override
    public Result<MonedaInfoDTO> getById(String index) {
        return this.monedaRepository.getById(index);
    }

}
