package com.justin.banco.service;

import java.util.List; 

import com.justin.banco.helpers.Result;

// T = Clase
// C = DTO CLASE CREATE
public interface CommonService<T0, T1, T2, T3, T4, N> {

    Result<T1> create(T2 entity);

    Result<T1> update(T3 entity);

    Result<String> delete(N code);

    // Result<List<T1>> getAll(T4 entity);

    Result<List<T0>> getBanksInJson(T4 entity);

    // Result<List<T1>> getByIdInList(N index);

    Result<T1> getById(N index);

}
