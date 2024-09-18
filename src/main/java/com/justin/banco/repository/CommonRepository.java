package com.justin.banco.repository;

import java.util.List;

import com.justin.banco.helpers.Result;

// T = Clase
// E = Id de clase
public interface CommonRepository<T0, T1, T2, T3, T4, N> {

    Result<T1> create(T2 entity);

    Result<T1> update(T3 entity);

    Result<String> delete(N item);

    // Result<List<T1>> getAll(T4 entity);

    // List<Map<String, Object>> getBanksInJson(T4 entity);
    Result<List<T0>> getBanksInJson(T4 entity);

    // Result<List<T1>> getByIdInList(N index);

    Result<T1> getById(N index);
}
