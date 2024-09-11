package com.justin.banco.helpers;

public class ResultCodeDB {

    public static final int SUCCESS = 0;
    public static final int NULL_VARIABLE = 1;
    public static final int EMPTY_VARIABLE = 2;
    public static final int TABLE_CODE_EXISTS = 3;
    public static final int FOREIGN_KEY_NOT_EXIST = 4;
    public static final int SPECIAL_CHARACTER_VALUES = 5;
    public static final int VALUE_TOO_LONG = 6;
    public static final int PRIMARY_KEY_NOT_EXIST = 7;
}
// -- 0 = Exitoso
// -- 1 = 1 o n variables con valor null 
// -- 2 = 1 o n variables con valor vacio
// -- 3 = codigo banco existente
// -- 4 = llave foranea no existente
// -- 5 = 1 o n variables con caracteres especiales
// -- 6 = 1 o n variables tamaño valor mayor al permitido
