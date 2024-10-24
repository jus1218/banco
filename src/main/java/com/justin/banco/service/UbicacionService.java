package com.justin.banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

import com.justin.banco.dto.Ubicacion.ProvinciaDetailDTO;
import com.justin.banco.dto.Ubicacion.ProvinciaPaginationDTO;
import com.justin.banco.dto.Ubicacion.UbicacionInfoDTO;
import com.justin.banco.dto.Ubicacion.UbicationCreateDTO;
import com.justin.banco.dto.Ubicacion.UbicationDeleteDTO;
import com.justin.banco.dto.Ubicacion.UbicationUpdatedDTO;
import com.justin.banco.dto.Ubicacion.UbicationUpdatedRelationDTO;
import com.justin.banco.helpers.Result;
import com.justin.banco.models.Provincia;
import com.justin.banco.models.Ubicacion;
import com.justin.banco.repository.UbicacionRepository;

@Service
public class UbicacionService {

    private @Autowired UbicacionRepository ubicacionRepository;

    public Result<List<Provincia>> getProvinciasCantonesDistritos() {
        return this.ubicacionRepository.getProvinciasCantonesDistritos();
    }

    public Result<UbicacionInfoDTO> createProvince(UbicationCreateDTO entity) {
        return this.ubicacionRepository.<Provincia>createProvince(entity, Provincia.class);
    }

    public Result<UbicacionInfoDTO> getUbication(Ubicacion Ubication) {
        return this.ubicacionRepository.getUbication(Ubication);
    }

    public Result<List<ProvinciaDetailDTO>> getProvincies(ProvinciaPaginationDTO pagination) {
        return this.ubicacionRepository.getProvincies(pagination);
    }

    public Result<Provincia> getProvincie(Integer code) {
        return this.ubicacionRepository.getProvincie(code);
    }

    public Result<UbicacionInfoDTO> updateUbication(UbicationUpdatedDTO ubication) {

        return this.ubicacionRepository.updateUbication(ubication);
    }
     
    public Result<UbicacionInfoDTO> deleteUbicationById(UbicationDeleteDTO ubicationDelete) {
        return this.ubicacionRepository.deleteUbicationById(ubicationDelete);
      
    }

}
