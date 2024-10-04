package com.justin.banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justin.banco.helpers.Result;
import com.justin.banco.models.Provincia;
import com.justin.banco.repository.UbicacionRepository;

@Service
public class UbicacionService {

    private @Autowired UbicacionRepository ubicacionRepository;

    public Result<List<Provincia>> getProvinciasCantonesDistritos() {
        return this.ubicacionRepository.getProvinciasCantonesDistritos();
    }

}
