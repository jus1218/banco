package com.justin.banco.service;

import com.justin.banco.helpers.Result;

public interface CompositeKeyService<T, T1> {

    Result<T1> DeleteByCompositePrimaryKey(T entity);
    Result<T1> getByCompositePrimaryKey(T entity);

}
