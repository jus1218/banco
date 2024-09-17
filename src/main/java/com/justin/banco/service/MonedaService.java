package com.justin.banco.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justin.banco.dto.moneda.MonedaCreateDTO;
import com.justin.banco.dto.moneda.MonedaPaginationDTO;
import com.justin.banco.dto.moneda.MonedaUpdateDTO;
import com.justin.banco.helpers.Result;
import com.justin.banco.models.Moneda;
import com.justin.banco.repository.MonedaRepository;

@Service
public class MonedaService
        implements CommonService<Moneda, MonedaCreateDTO, MonedaUpdateDTO, MonedaPaginationDTO, String> {

    private @Autowired MonedaRepository monedaRepository;

    @Override
    public Result<MonedaCreateDTO> create(MonedaCreateDTO entity) {
        return this.monedaRepository.create(entity);
    }

    @Override
    public Result<MonedaUpdateDTO> update( MonedaUpdateDTO entity)  {
        return this.monedaRepository.update(entity);
    }

    @Override
    public Result<String> delete(String code) {
        return this.monedaRepository.delete(code);
    }

    @Override
    public Result<List<Moneda>> getAll(MonedaPaginationDTO entity) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public List<Map<String, Object>> getBanksInJson(MonedaPaginationDTO entity) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBanksInJson'");
    }

    @Override
    public Result<List<Moneda>> getByIdInList(String index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByIdInList'");
    }

    @Override
    public Result<Moneda> getById(String index) {
        return this.monedaRepository.getById(index);
    }

}
