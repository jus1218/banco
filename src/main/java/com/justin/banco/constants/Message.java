package com.justin.banco.constants;

public enum Message {
    // * MENSAJES GENERICOS

    EMPTY(""),
    SUCCESS("Muy bien acción procesada correctamente."),
    FAILURE("Error al procesar la informacion, verifique los datos."),
    NULL_VARIABLE("Error informacion incompleta, llene todos los datos solicitados."),
    EMPTY_VARIABLE("Error informacion incompleta, llene todos los datos solicitados."),
    TABLE_CODE_EXISTS("Error al procesar la informacion, codigo existente."),
    FOREIGN_KEY_NOT_EXIST("Error, verifique los valores de relación"),
    SPECIAL_CHARACTER_VALUES("Error no se admite caracteres especiales, solamente en descripcion"),
    VALUE_TOO_LONG("Error, informacion con valores que sobrepasan lo permitido."),
    PRIMARY_KEY_NOT_EXIST("Error, codigo inexistente."),
    PROCEDURE_NOT_EXECUTED("Procedimiento no ejecutado"),

    // * ==================== BANCO =========================
    BANK_SUCCESS("Muy bien acción al banco procesada correctamente."),
    BANK_NULL_VARIABLE("Error informacion incompleta, llene todos los datos solicitados del banco."),
    BANK_EMPTY_VARIABLE("Error informacion incompleta, llene todos los datos solicitados del banco."),
    BANK_TABLE_CODE_EXISTS("Error al procesar la informacion, codigo banco existente."),
    BANK_FOREIGN_KEY_NOT_EXIST("Error, verifique los campos distrito y moneda"),
    BANK_PRIMARY_KEY_NOT_EXIST("Error, codigo banco no existe."),
    // * ========================= CLIENTE ==============================
    CLIENT_SUCCESS("Muy bien acción al cliente procesada correctamente."),
    CLIENT_NULL_VARIABLE("Error informacion incompleta, llene todos los datos solicitados del cliente."),
    CLIENT_EMPTY_VARIABLE("Error informacion incompleta, llene todos los datos solicitados del cliente."),
    CLIENT_TABLE_CODE_EXISTS("Error al procesar la informacion, codigo cliente existente."),
    CLIENT_FOREIGN_KEY_NOT_EXIST("Error, verifique los campos distrito y moneda"),
    CLIENT_PRIMARY_KEY_NOT_EXIST("Error, codigo cliente no existe."),
    // * ========================= CLIENTE ==============================
    CURRENCY_SUCCESS("Muy bien moneda procesada correctamente."),
    CURRENCY_NULL_VARIABLE("Error informacion incompleta, llene todos los datos solicitados de la moneda."),
    CURRENCY_EMPTY_VARIABLE("Error informacion incompleta, llene todos los datos solicitados de la moneda."),
    CURRENCY_TABLE_CODE_EXISTS("Error al procesar la informacion, codigo moneda existente."),
    CURRENCY_PRIMARY_KEY_NOT_EXIST("Error, codigo moneda no existe."),

    // * EXCEPTIONS
    I_LLEGAL_ACCESS_EXCEPTION(
            "Uno o más de los argumentos proporcionados son inválidos. Por favor, revisa los valores de entrada y asegúrate de que cumplan con el formato y las restricciones requeridas."),

    JSON_PROCESSING_EXCEPTION(
            "Ocurrió un error al procesar el JSON. Esto puede deberse a un formato de JSON incorrecto o a datos que no se pudieron deserializar correctamente."),

    UNCAUGHT_EXCEPTION("Excepción no controlada,informe a desarrollo.");

    private final String message;

    Message(String message) {
        this.message = message;

    }

    public String getMessage() {
        return message;
    }

}
