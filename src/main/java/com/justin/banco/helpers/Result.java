package com.justin.banco.helpers;

 

public class Result<T> {
    private final T value;
    private final String message;
    private final boolean isSuccess;

    public Result(T value, String message, boolean isSuccess) {
        this.value = value;
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public static <T> Result<T> get(T valor, String message, int resultCodeDB) {

        if (resultCodeDB == ResultCodeDB.SUCCESS)
            return success(valor, message);

        return failure(message);

    }

    public static <T> Result<T> success(T valor, String message) {
        return new Result<T>(valor, message, true);
    }

    public static <T> Result<T> failure(String msg) {
        // return new Result<T>(null, msg, false);
        // throw new ResponseStatusException(HttpStatus.BAD_REQUEST, msg);
        // throw new CustomBadRequestException(msg);
        throw new RuntimeException(msg);
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
