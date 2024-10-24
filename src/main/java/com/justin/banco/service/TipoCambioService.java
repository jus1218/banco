package com.justin.banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justin.banco.dto.tipocambio.*;
import com.justin.banco.helpers.Result;
import com.justin.banco.models.TipoCambio;
import com.justin.banco.repository.TipoCambioRepository;

@Service
public class TipoCambioService implements
        CommonService<TipoCambio, TipoCambioInfoDTO, TipoCambioCreateDTO, TipoCambioUpdateDTO, TipoCambioPaginationDTO, String>,
        CompositeKeyService<TipoCambioDeleteAndUpdateDTO, TipoCambioInfoDTO> {

    private @Autowired TipoCambioRepository tipoCambioRepository;

    @Override
    public Result<TipoCambioInfoDTO> create(TipoCambioCreateDTO entity) {
        return this.tipoCambioRepository.create(entity);
    }

    @Override
    public Result<TipoCambioInfoDTO> update(TipoCambioUpdateDTO entity) {
        return this.tipoCambioRepository.update(entity);
    }

    @Override
    public Result<String> delete(String code) {
        return this.tipoCambioRepository.delete(code);
    }

    @Override
    public Result<List<TipoCambio>> getList(TipoCambioPaginationDTO entity) {
        return this.tipoCambioRepository.getList(entity);
    }

    @Override
    public Result<TipoCambioInfoDTO> getById(String index) {
        throw new UnsupportedOperationException("Metodo inexistente.");
    }

    @Override
    public Result<TipoCambioInfoDTO> DeleteByCompositePrimaryKey(TipoCambioDeleteAndUpdateDTO entity) {
        return this.tipoCambioRepository.DeleteByCompositePrimaryKey(entity);
    }

    @Override
    public Result<TipoCambioInfoDTO> getByCompositePrimaryKey(TipoCambioDeleteAndUpdateDTO entity) {
        return this.tipoCambioRepository.getByCompositePrimaryKey(entity);
    }

}
