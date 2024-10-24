package com.justin.banco.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justin.banco.dto.cuentacliente.CuentaClienteCreateDTO;
import com.justin.banco.dto.cuentacliente.CuentaClienteInfoDTO;
import com.justin.banco.dto.cuentacliente.CuentaClientePaginacionDTO;
import com.justin.banco.dto.cuentacliente.CuentaClienteUpdateDTO;
import com.justin.banco.helpers.Result;
import com.justin.banco.models.CuentaCliente;
import com.justin.banco.models.Selector;
import com.justin.banco.repository.CuentaClienteRepository;

@Service
public class CuentaClienteService implements
        CommonService<CuentaCliente, CuentaClienteInfoDTO, CuentaClienteCreateDTO, CuentaClienteUpdateDTO, CuentaClientePaginacionDTO, Long> {

    private @Autowired CuentaClienteRepository cuentaClienteRepository;

    @Override
    public Result<CuentaClienteInfoDTO> create(CuentaClienteCreateDTO entity) {
        return this.cuentaClienteRepository.create(entity);
    }

    @Override
    public Result<CuentaClienteInfoDTO> update(CuentaClienteUpdateDTO entity) {

        return this.cuentaClienteRepository.update(entity);
    }

    @Override
    public Result<String> delete(Long code) {
        return this.cuentaClienteRepository.delete(code);
    }

    @Override
    public Result<List<CuentaCliente>> getList(CuentaClientePaginacionDTO entity) {
        return this.cuentaClienteRepository.getList(entity);
    }

    @Override
    public Result<CuentaClienteInfoDTO> getById(Long index) {
        return this.cuentaClienteRepository.getById(index);
    }

    public Result<Selector> getDataSelectores() {

        return this.cuentaClienteRepository.getDataSelectores();
    }

}
