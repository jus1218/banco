package com.justin.banco.helpers.mappers;

import com.justin.banco.dto.moneda.MonedaCreateDTO;
import com.justin.banco.dto.moneda.MonedaUpdateDTO;
import com.justin.banco.models.Moneda;

public class MonedaMapper {

    public static MonedaCreateDTO toCreateCurrencyDTO(Moneda moneda) {
        if (moneda == null)
            return null;
        return new MonedaCreateDTO(moneda.getCodigoMoneda(), moneda.getNombre());
    }

    public static MonedaUpdateDTO toUpdateCurrencyDTO(Moneda moneda) {
        if (moneda == null)
            return null;
        return new MonedaUpdateDTO(moneda.getCodigoMoneda(), moneda.getNombre());
    }

}
