package com.justin.banco.constants;

public class ResultCodeDB {
    public static final int I_LLEGAL_ACCESS_EXCEPTION = -4;
    public static final int JSON_PROCESSING_EXCEPTION = -3;

    public static final int PROCEDURE_NOT_EXECUTED = -2;
    public static final int EMPTY = -1;
    public static final int SUCCESS = 0;
    public static final int NULL_VARIABLE = 1;
    public static final int EMPTY_VARIABLE = 2;
    public static final int TABLE_CODE_EXISTS = 3;
    public static final int FOREIGN_KEY_NOT_EXIST = 4;
    public static final int SPECIAL_CHARACTER_VALUES = 5;
    public static final int VALUE_TOO_LONG = 6;
    public static final int PRIMARY_KEY_NOT_EXIST = 7;

    public static final int CREATE = 10;
    public static final int DELETE = 11;
    public static final int UPDATED = 12;
    public static final int NO_DELETE = 13;

    public static final int ERROR_TYPE = 20;

    public static final int TYPE_PROVINCE = 0;

    public static boolean isSuccessResultCode(int resultCode) {

        if (resultCode == ResultCodeDB.SUCCESS || resultCode == ResultCodeDB.CREATE
                || resultCode == ResultCodeDB.UPDATED || resultCode == ResultCodeDB.DELETE) {
            return true;
        }

        return false;
    }
}
// -- 0 = Exitoso
// -- 1 = 1 o n variables con valor null
// -- 2 = 1 o n variables con valor vacio
// -- 3 = codigo banco existente
// -- 4 = llave foranea no existente
// -- 5 = 1 o n variables con caracteres especiales
// -- 6 = 1 o n variables tamaño valor mayor al permitido
