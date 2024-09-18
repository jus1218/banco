package com.justin.banco.helpers.mappers;

import com.justin.banco.dto.moneda.MonedaCreateDTO;
import com.justin.banco.dto.moneda.MonedaUpdateDTO;
import com.justin.banco.dto.moneda.MonedaInfoDTO;

public class MonedaMapper {

    public static MonedaCreateDTO toCreateCurrencyDTO(MonedaInfoDTO moneda) {
        if (moneda == null)
            return null;
        return new MonedaCreateDTO(moneda.getCodigoMoneda(), moneda.getNombre());
    }

    public static MonedaUpdateDTO toUpdateCurrencyDTO(MonedaInfoDTO moneda) {
        if (moneda == null)
            return null;
        return new MonedaUpdateDTO(moneda.getCodigoMoneda(), moneda.getNombre());
    }

}
