package com.justin.banco.service;

import java.util.List;
import java.util.Map;

import com.justin.banco.helpers.Result;

// T = Clase
// C = DTO CLASE CREATE
public interface CommonService<T1, T2, T3, T4, N> {

    Result<T2> create(T2 entity);

    Result<T3> update(  T3 entity);

    Result<String> delete(N code);

    Result<List<T1>> getAll(T4 entity) throws Exception;

    List<Map<String, Object>> getBanksInJson(T4 entity) throws Exception;

    Result<List<T1>> getByIdInList(N index);

    Result<T1> getById(N index);

}
