package com.justin.banco.helpers;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.justin.banco.constants.Message;
import com.justin.banco.constants.ResultCodeDB;

public class Result<T> {
    private final T value;
    private final String message;
    private final boolean isSuccess;

    public Result(T value, Message message, boolean isSuccess) {
        this.value = value;
        this.message = message.getMessage();
        this.isSuccess = isSuccess;
    }

    public static <T> Result<T> get(T valor, Message message, int resultCode) {

        if (resultCode == ResultCodeDB.SUCCESS)
            return success(valor, message);

        return failure(message, resultCode);

    }

    public static <T> Result<T> success(T valor, Message message) {
        return new Result<T>(valor, message, true);
    }

    public static <T> Result<T> failure(Message msg, int resultCode) {

        if (resultCode == ResultCodeDB.PRIMARY_KEY_NOT_EXIST) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, msg.getMessage());
        }
        throw new RuntimeException(msg.getMessage());

    }

    public T getValue() {
        if (this.isSuccess)
            return this.value;

        return null;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

}
