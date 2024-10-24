package com.justin.banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justin.banco.dto.cuentacontable.CuentaContableCreateDTO;
import com.justin.banco.dto.cuentacontable.CuentaContableInfoDTO;
import com.justin.banco.dto.cuentacontable.CuentaContablePaginationDTO;
import com.justin.banco.dto.cuentacontable.CuentaContableUpdateDTO;
import com.justin.banco.helpers.Result;
import com.justin.banco.models.CuentaContable;
import com.justin.banco.repository.CuentaContableRepository;
@Service
public class CuentaContableService implements
        CommonService<CuentaContable, CuentaContableInfoDTO, CuentaContableCreateDTO, CuentaContableUpdateDTO, CuentaContablePaginationDTO, Long> {

    private @Autowired CuentaContableRepository CuentaContableRepository;

    @Override
    public Result<CuentaContableInfoDTO> create(CuentaContableCreateDTO entity) {

        return this.CuentaContableRepository.create(entity);
    }

    @Override
    public Result<CuentaContableInfoDTO> update(CuentaContableUpdateDTO entity) {

        return this.CuentaContableRepository.update(entity);
    }

    @Override
    public Result<String> delete(Long code) {

        return this.CuentaContableRepository.delete(code);
    }

    @Override
    public Result<List<CuentaContable>> getList(CuentaContablePaginationDTO entity) {

        return this.CuentaContableRepository.getList(entity);
    }

    @Override
    public Result<CuentaContableInfoDTO> getById(Long index) {

        return this.CuentaContableRepository.getById(index);
    }

}
