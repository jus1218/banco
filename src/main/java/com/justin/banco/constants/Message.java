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
    BANK_CREATE_SUCCESS("Banco creado satisfactoriamente."),
    BANK_UPDATE_SUCCESS("Banco actualizado satisfactoriamente."),
    BANK_DELETE_SUCCESS("Banco eliminado satisfactoriamente."),
    BANK_NO_DELETE("Error, Banco ya se encuentra asociado a otros registros"),
    
    BANK_SUCCESS("Muy bien acción al banco procesada correctamente."),
    BANK_NULL_VARIABLE("Error informacion incompleta, llene todos los datos solicitados del banco."),
    BANK_EMPTY_VARIABLE("Error informacion incompleta, llene todos los datos solicitados del banco."),
    BANK_TABLE_CODE_EXISTS("Error al procesar la informacion, codigo banco existente."),
    BANK_FOREIGN_KEY_NOT_EXIST("Error, verifique los campos distrito y moneda"),
    BANK_PRIMARY_KEY_NOT_EXIST("Error, codigo banco no existe."),
    // * ========================= CLIENTE ==============================
    CLIENT_CREATE_SUCCESS("Cliente creado satisfactoriamente."),
    CLIENT_UPDATE_SUCCESS("Cliente actualizado satisfactoriamente."),
    CLIENT_DELETE_SUCCESS("Cliente eliminado satisfactoriamente."),
    
    CLIENT_NO_DELETE("Error, Cliente ya se encuentra asociado a otros registros"),
    
    CLIENT_SUCCESS("Muy bien acción al cliente procesada correctamente."),
    CLIENT_NULL_VARIABLE("Error informacion incompleta, llene todos los datos solicitados del cliente."),
    CLIENT_EMPTY_VARIABLE("Error informacion incompleta, llene todos los datos solicitados del cliente."),
    CLIENT_TABLE_CODE_EXISTS("Error al procesar la informacion, codigo cliente existente."),
    CLIENT_FOREIGN_KEY_NOT_EXIST("Error, verifique los campos distrito y moneda"),
    CLIENT_PRIMARY_KEY_NOT_EXIST("Error, codigo cliente no existe."),
    // * ========================= MONEDA ==============================
    
    CURRENCY_CREATE_SUCCESS("Moneda creada satisfactoriamente."),
    CURRENCY_UPDATE_SUCCESS("Moneda actualizada satisfactoriamente."),
    CURRENCY_DELETE_SUCCESS("Moneda eliminada satisfactoriamente."),
    CURRENCY_NO_DELETE("Error, Moneda ya se encuentra asociado a otros registros"),
    
    CURRENCY_SUCCESS("Muy bien moneda procesada correctamente."),
    CURRENCY_NULL_VARIABLE("Error informacion incompleta, llene todos los datos solicitados de la moneda."),
    CURRENCY_EMPTY_VARIABLE("Error informacion incompleta, llene todos los datos solicitados de la moneda."),
    CURRENCY_TABLE_CODE_EXISTS("Error al procesar la informacion, codigo moneda existente."),
    CURRENCY_PRIMARY_KEY_NOT_EXIST("Error, codigo moneda no existe."),
    // * ========================= TIPO_CAMBIO ==============================
    EXCHANGE_RATE_CREATE_SUCCESS("Tipo cambio creado satisfactoriamente."),
    EXCHANGE_RATE_UPDATE_SUCCESS("Tipo cambio actualizado satisfactoriamente."),
    EXCHANGE_RATE_DELETE_SUCCESS("Tipo cambio eliminado satisfactoriamente."),
    
    EXCHANGE_RATE_SUCCESS("Muy bien tipo cambio procesado correctamente."),
    EXCHANGE_RATE_NULL_VARIABLE("Error informacion incompleta, llene todos los datos solicitados del tipo cambio."),
    EXCHANGE_RATE_EMPTY_VARIABLE("Error informacion incompleta, llene todos los datos solicitados del tipo cambio."),
    EXCHANGE_RATE_TABLE_CODE_EXISTS("Error al procesar la informacion, tipo cambio existente."),
    EXCHANGE_RATE_FOREIGN_KEY_NOT_EXIST("Error, verifique los campos moneda y banco"),
    EXCHANGE_RATE_PRIMARY_KEY_NOT_EXIST("Error, tipo cambio no existe."),
    // * ========================= TELEFONO ==============================
    PHONE_CREATE_SUCCESS("Telefono creado satisfactoriamente."),
    PHONE_UPDATE_SUCCESS("Telefono actualizado satisfactoriamente."),
    PHONE_DELETE_SUCCESS("Telefono eliminado satisfactoriamente."),
    
    PHONE_SUCCESS("Muy bien telefono procesado correctamente."),
    PHONE_NULL_VARIABLE("Error informacion incompleta, llene todos los datos solicitados del telefono."),
    PHONE_EMPTY_VARIABLE("Error informacion incompleta, llene todos los datos solicitados del telefono."),
    PHONE_TABLE_CODE_EXISTS("Error al procesar la informacion, telefono existente."),
    PHONE_FOREIGN_KEY_NOT_EXIST("Error, verifique los campos cliente o banco"),
    PHONE_PRIMARY_KEY_NOT_EXIST("Error, telefono no existente."),
    // * ========================= CUENTA CLIENTE ==============================
    CLIENT_ACCOUNT_CREATE_SUCCESS("Cuenta cliente creada satisfactoriamente."),
    CLIENT_ACCOUNT_UPDATE_SUCCESS("Cuenta cliente actualizada satisfactoriamente."),
    CLIENT_ACCOUNT_DELETE_SUCCESS("Cuenta cliente eliminada satisfactoriamente."),
    CLIENT_ACCOUNT_NO_DELETE("Error, Cuenta cliente ya se encuentra asociado a otros registros"),
    
    CLIENT_ACCOUNT_SUCCESS("Muy bien cuenta cliente procesada correctamente."),
    CLIENT_ACCOUNT_NULL_VARIABLE(
            "Error informacion incompleta, llene todos los datos solicitados de la cuenta cliente."),
    CLIENT_ACCOUNT_EMPTY_VARIABLE(
            "Error informacion incompleta, llene todos los datos solicitados de la cuenta cliente."),
    CLIENT_ACCOUNT_TABLE_CODE_EXISTS("Error al procesar la informacion, cuenta cliente existente."),
    CLIENT_ACCOUNT_FOREIGN_KEY_NOT_EXIST(
            "Error, verifique los campos banco, moneda, tipo de cuenta cliente o cuenta contable"),
    CLIENT_ACCOUNT_PRIMARY_KEY_NOT_EXIST("Error, cuenta cliente no existente."),
    // * ========================= UBICACION ==============================
    UBICATION_CREATE_SUCCESS("Ubicación creada satisfactoriamente."),
    UBICATION_UPDATE_SUCCESS("Ubicación actualizada satisfactoriamente."),
    UBICATION_DELETE_SUCCESS("Ubicación eliminada satisfactoriamente."),

    UBICATION_SUCCESS("Muy bien Ubicación procesada correctamente."),
    UBICATION_NULL_VARIABLE("Error informacion incompleta, llene todos los datos solicitados de la Ubicación."),
    UBICATION_EMPTY_VARIABLE("Error informacion incompleta, llene todos los datos solicitados de la Ubicación."),
    UBICATION_TABLE_CODE_EXISTS("Error al procesar la informacion, Ubicación existente."),
    UBICATION_FOREIGN_KEY_NOT_EXIST("Error, verifique los campos realción"),
    UBICATION_PRIMARY_KEY_NOT_EXIST("Error, Ubicación no existente."),
    UBICATION_ERROR_TYPE("Error, valor de tipo erroneo"),
    UBICATION_NO_DELETE("Error, Ubicación ya se encuentra asociada a otros registros"),
    // * ========================= UBICACION ==============================
    CUENTA_CONTABLE_CREATE_SUCCESS("Cuenta Contable creada satisfactoriamente."),
    CUENTA_CONTABLE_UPDATE_SUCCESS("Cuenta Contable actualizada satisfactoriamente."),
    CUENTA_CONTABLE_DELETE_SUCCESS("Cuenta Contable eliminada satisfactoriamente."),

    CUENTA_CONTABLE_SUCCESS("Muy bien Cuenta Contable procesada correctamente."),
    CUENTA_CONTABLE_NULL_VARIABLE("Error informacion incompleta, llene todos los datos solicitados de la Cuenta Contable."),
    CUENTA_CONTABLE_EMPTY_VARIABLE("Error informacion incompleta, llene todos los datos solicitados de la Cuenta Contable."),
    CUENTA_CONTABLE_TABLE_CODE_EXISTS("Error al procesar la informacion, Cuenta Contable existente."),
    CUENTA_CONTABLE_FOREIGN_KEY_NOT_EXIST("Error, verifique los campos realción"),
    CUENTA_CONTABLE_PRIMARY_KEY_NOT_EXIST("Error, Cuenta Contable no existente."),
    CUENTA_CONTABLE_ERROR_TYPE("Error, valor de tipo erroneo"),
    CUENTA_CONTABLE_NO_DELETE("Error, Cuenta Contable ya se encuentra asociada a otros registros"),

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
