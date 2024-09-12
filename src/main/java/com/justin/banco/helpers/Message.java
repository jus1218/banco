package com.justin.banco.helpers;
// Version 1
public class Message {
    // * MENSAJES GENERICOS
    public static final String SUCCESS = "Muy bien acción procesada correctamente.";
    public static final String FAILURE = "Error al procesar la informacion, verifique los datos.";
    public static final String NULL_VARIABLE = "Error informacion incompleta, llene todos los datos solicitados.";
    public static final String EMPTY_VARIABLE = "Error informacion incompleta, llene todos los datos solicitados.";
    public static final String TABLE_CODE_EXISTS = "Error al procesar la informacion, codigo existente.";
    public static final String FOREIGN_KEY_NOT_EXIST = "Error, verifique los valores de relación";
    public static final String SPECIAL_CHARACTER_VALUES = "Error no se admite caracteres especiales, solamente en descripcion";
    public static final String VALUE_TOO_LONG = "Error, informacion con valores que sobrepasan lo permitido.";
    public static final String PRIMARY_KEY_NOT_EXIST = "Error al actualizar, codigo inexistente.";
    
    // * MENSAJES ESPECIFICOS
    public static final String BANK_SUCCESS = "Muy bien banco creado correctamente.";
    public static final String BANK_FAILURE = "Error al procesar la informacion, verifique los datos del banco.";
    public static final String BANK_NULL_VARIABLE = "Error informacion incompleta, llene todos los datos solicitados del banco.";
    public static final String BANK_EMPTY_VARIABLE = "Error informacion incompleta, llene todos los datos solicitados del banco.";
    public static final String BANK_TABLE_CODE_EXISTS = "Error al procesar la informacion, codigo banco existente.";
    public static final String BANK_FOREIGN_KEY_NOT_EXIST = "Error, verifique los campos distrito y moneda";
    public static final String BANK_PRIMARY_KEY_NOT_EXIST = "Error, codigo banco no existe.";

    static public String getBankMessage(int resultCode) {

        switch (resultCode) {
            case ResultCodeDB.SUCCESS:
                return Message.BANK_SUCCESS;
            case ResultCodeDB.NULL_VARIABLE:
                return Message.BANK_NULL_VARIABLE;
            case ResultCodeDB.EMPTY_VARIABLE:
                return Message.BANK_EMPTY_VARIABLE;
            case ResultCodeDB.TABLE_CODE_EXISTS:
                return Message.BANK_TABLE_CODE_EXISTS;
            case ResultCodeDB.FOREIGN_KEY_NOT_EXIST:
                return Message.BANK_FOREIGN_KEY_NOT_EXIST;
            case ResultCodeDB.SPECIAL_CHARACTER_VALUES:
                return Message.SPECIAL_CHARACTER_VALUES;
            case ResultCodeDB.VALUE_TOO_LONG:
                return Message.VALUE_TOO_LONG;
            case ResultCodeDB.PRIMARY_KEY_NOT_EXIST:
                return Message.BANK_PRIMARY_KEY_NOT_EXIST;

            default:
                return Message.BANK_FAILURE;
        }

    }

}
