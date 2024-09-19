package com.justin.banco.repository;

import com.justin.banco.helpers.Result;

public interface CompositeKeyRepository<T, T1> {

    Result<T1> DeleteByCompositePrimaryKey(T entity);
    Result<T1> getByCompositePrimaryKey(T entity);

}
