package com.justin.banco.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.justin.banco.constants.Message;
import com.justin.banco.constants.ResultCodeDB;
import com.justin.banco.dto.cliente.ClienteInfoDTO;
import com.justin.banco.models.Banco;
import com.justin.banco.models.CuentaCliente;
import com.justin.banco.models.CuentaContable;
import com.justin.banco.models.Moneda;
import com.justin.banco.models.Telefono;
import com.justin.banco.models.TipoCambio;
import com.justin.banco.models.Ubicacion;

@Service
public class MessageManager {
    // Contiene los demas mapas
    private static final Map<Class<?>, Map<Integer, Message>> typeMessageMap = new HashMap<Class<?>, Map<Integer, Message>>();
    // Contiene los mensajes de excepciones
    private static final Map<Integer, Message> exeptionsMessages = new HashMap<Integer, Message>();

    private static final Map<Integer, Message> genericMessages = new HashMap<Integer, Message>();
    private static final Map<Integer, Message> clientMessage = new HashMap<Integer, Message>();
    private static final Map<Integer, Message> bankMessages = new HashMap<Integer, Message>();
    private static final Map<Integer, Message> currencyMessages = new HashMap<Integer, Message>();
    private static final Map<Integer, Message> exchangeRateMessages = new HashMap<Integer, Message>();
    private static final Map<Integer, Message> phoneMessages = new HashMap<Integer, Message>();
    private static final Map<Integer, Message> clientAccountMessages = new HashMap<Integer, Message>();
    private static final Map<Integer, Message> ubicationMessages = new HashMap<Integer, Message>();
    private static final Map<Integer, Message> cuentaContableMessages = new HashMap<Integer, Message>();

    static {
        genericMessages.put(ResultCodeDB.SUCCESS, Message.SUCCESS);
        genericMessages.put(ResultCodeDB.NULL_VARIABLE, Message.NULL_VARIABLE);
        genericMessages.put(ResultCodeDB.EMPTY_VARIABLE, Message.EMPTY_VARIABLE);
        genericMessages.put(ResultCodeDB.TABLE_CODE_EXISTS, Message.TABLE_CODE_EXISTS);
        genericMessages.put(ResultCodeDB.FOREIGN_KEY_NOT_EXIST, Message.FOREIGN_KEY_NOT_EXIST);
        genericMessages.put(ResultCodeDB.PRIMARY_KEY_NOT_EXIST, Message.PRIMARY_KEY_NOT_EXIST);
        genericMessages.put(ResultCodeDB.SPECIAL_CHARACTER_VALUES, Message.SPECIAL_CHARACTER_VALUES);
        genericMessages.put(ResultCodeDB.VALUE_TOO_LONG, Message.VALUE_TOO_LONG);

        // Inicializacion de mensajes para Cliente

        clientMessage.put(ResultCodeDB.CREATE, Message.CLIENT_CREATE_SUCCESS);
        clientMessage.put(ResultCodeDB.UPDATED, Message.CLIENT_UPDATE_SUCCESS);
        clientMessage.put(ResultCodeDB.DELETE, Message.CLIENT_DELETE_SUCCESS);

        clientMessage.put(ResultCodeDB.SUCCESS, Message.CLIENT_SUCCESS);
        clientMessage.put(ResultCodeDB.NULL_VARIABLE, Message.CLIENT_NULL_VARIABLE);
        clientMessage.put(ResultCodeDB.EMPTY_VARIABLE, Message.CLIENT_EMPTY_VARIABLE);
        clientMessage.put(ResultCodeDB.TABLE_CODE_EXISTS, Message.CLIENT_TABLE_CODE_EXISTS);
        clientMessage.put(ResultCodeDB.FOREIGN_KEY_NOT_EXIST, Message.CLIENT_FOREIGN_KEY_NOT_EXIST);
        clientMessage.put(ResultCodeDB.PRIMARY_KEY_NOT_EXIST, Message.CLIENT_PRIMARY_KEY_NOT_EXIST);
        clientMessage.put(ResultCodeDB.SPECIAL_CHARACTER_VALUES, Message.SPECIAL_CHARACTER_VALUES);
        clientMessage.put(ResultCodeDB.VALUE_TOO_LONG, Message.VALUE_TOO_LONG);
        clientMessage.put(ResultCodeDB.NO_DELETE, Message.CLIENT_NO_DELETE);
        // Inicializacion de mensajes para Banco
        bankMessages.put(ResultCodeDB.CREATE, Message.BANK_CREATE_SUCCESS);
        bankMessages.put(ResultCodeDB.UPDATED, Message.BANK_UPDATE_SUCCESS);
        bankMessages.put(ResultCodeDB.DELETE, Message.BANK_DELETE_SUCCESS);
        bankMessages.put(ResultCodeDB.NO_DELETE, Message.BANK_NO_DELETE);

        bankMessages.put(ResultCodeDB.SUCCESS, Message.BANK_SUCCESS);
        bankMessages.put(ResultCodeDB.NULL_VARIABLE, Message.BANK_NULL_VARIABLE);
        bankMessages.put(ResultCodeDB.EMPTY_VARIABLE, Message.BANK_EMPTY_VARIABLE);
        bankMessages.put(ResultCodeDB.TABLE_CODE_EXISTS, Message.BANK_TABLE_CODE_EXISTS);
        bankMessages.put(ResultCodeDB.FOREIGN_KEY_NOT_EXIST, Message.BANK_FOREIGN_KEY_NOT_EXIST);
        bankMessages.put(ResultCodeDB.PRIMARY_KEY_NOT_EXIST, Message.BANK_PRIMARY_KEY_NOT_EXIST);
        bankMessages.put(ResultCodeDB.SPECIAL_CHARACTER_VALUES, Message.SPECIAL_CHARACTER_VALUES);
        bankMessages.put(ResultCodeDB.VALUE_TOO_LONG, Message.VALUE_TOO_LONG);
        // Inicializacion de mensajes para Moneda

        currencyMessages.put(ResultCodeDB.CREATE, Message.CURRENCY_CREATE_SUCCESS);
        currencyMessages.put(ResultCodeDB.UPDATED, Message.CURRENCY_UPDATE_SUCCESS);
        currencyMessages.put(ResultCodeDB.DELETE, Message.CURRENCY_DELETE_SUCCESS);
        currencyMessages.put(ResultCodeDB.NO_DELETE, Message.CURRENCY_NO_DELETE);

        currencyMessages.put(ResultCodeDB.SUCCESS, Message.CURRENCY_SUCCESS);
        currencyMessages.put(ResultCodeDB.NULL_VARIABLE, Message.CURRENCY_NULL_VARIABLE);
        currencyMessages.put(ResultCodeDB.EMPTY_VARIABLE, Message.CURRENCY_EMPTY_VARIABLE);
        currencyMessages.put(ResultCodeDB.TABLE_CODE_EXISTS, Message.CURRENCY_TABLE_CODE_EXISTS);
        currencyMessages.put(ResultCodeDB.PRIMARY_KEY_NOT_EXIST, Message.CURRENCY_PRIMARY_KEY_NOT_EXIST);
        currencyMessages.put(ResultCodeDB.SPECIAL_CHARACTER_VALUES, Message.SPECIAL_CHARACTER_VALUES);
        currencyMessages.put(ResultCodeDB.VALUE_TOO_LONG, Message.VALUE_TOO_LONG);
        // ===========================TIPO_CAMBIO==================================
        exchangeRateMessages.put(ResultCodeDB.CREATE, Message.EXCHANGE_RATE_CREATE_SUCCESS);
        exchangeRateMessages.put(ResultCodeDB.UPDATED, Message.EXCHANGE_RATE_UPDATE_SUCCESS);
        exchangeRateMessages.put(ResultCodeDB.DELETE, Message.EXCHANGE_RATE_DELETE_SUCCESS);

        exchangeRateMessages.put(ResultCodeDB.SUCCESS, Message.EXCHANGE_RATE_SUCCESS);
        exchangeRateMessages.put(ResultCodeDB.NULL_VARIABLE, Message.EXCHANGE_RATE_NULL_VARIABLE);
        exchangeRateMessages.put(ResultCodeDB.EMPTY_VARIABLE, Message.EXCHANGE_RATE_EMPTY_VARIABLE);
        exchangeRateMessages.put(ResultCodeDB.TABLE_CODE_EXISTS, Message.EXCHANGE_RATE_TABLE_CODE_EXISTS);
        exchangeRateMessages.put(ResultCodeDB.FOREIGN_KEY_NOT_EXIST, Message.EXCHANGE_RATE_FOREIGN_KEY_NOT_EXIST);
        exchangeRateMessages.put(ResultCodeDB.SPECIAL_CHARACTER_VALUES, Message.SPECIAL_CHARACTER_VALUES);
        exchangeRateMessages.put(ResultCodeDB.VALUE_TOO_LONG, Message.VALUE_TOO_LONG);
        exchangeRateMessages.put(ResultCodeDB.PRIMARY_KEY_NOT_EXIST, Message.EXCHANGE_RATE_PRIMARY_KEY_NOT_EXIST);
        // TELEFONO
        phoneMessages.put(ResultCodeDB.CREATE, Message.PHONE_CREATE_SUCCESS);
        phoneMessages.put(ResultCodeDB.UPDATED, Message.PHONE_UPDATE_SUCCESS);
        phoneMessages.put(ResultCodeDB.DELETE, Message.PHONE_DELETE_SUCCESS);

        phoneMessages.put(ResultCodeDB.SUCCESS, Message.PHONE_SUCCESS);
        phoneMessages.put(ResultCodeDB.NULL_VARIABLE, Message.PHONE_NULL_VARIABLE);
        phoneMessages.put(ResultCodeDB.EMPTY_VARIABLE, Message.PHONE_EMPTY_VARIABLE);
        phoneMessages.put(ResultCodeDB.TABLE_CODE_EXISTS, Message.PHONE_TABLE_CODE_EXISTS);
        phoneMessages.put(ResultCodeDB.FOREIGN_KEY_NOT_EXIST, Message.PHONE_FOREIGN_KEY_NOT_EXIST);
        phoneMessages.put(ResultCodeDB.SPECIAL_CHARACTER_VALUES, Message.SPECIAL_CHARACTER_VALUES);
        phoneMessages.put(ResultCodeDB.VALUE_TOO_LONG, Message.VALUE_TOO_LONG);
        phoneMessages.put(ResultCodeDB.PRIMARY_KEY_NOT_EXIST, Message.PHONE_PRIMARY_KEY_NOT_EXIST);
        // ===========================CUENTA CLIENTE==================================
        clientAccountMessages.put(ResultCodeDB.CREATE, Message.CLIENT_ACCOUNT_CREATE_SUCCESS);
        clientAccountMessages.put(ResultCodeDB.UPDATED, Message.CLIENT_ACCOUNT_UPDATE_SUCCESS);
        clientAccountMessages.put(ResultCodeDB.DELETE, Message.CLIENT_ACCOUNT_DELETE_SUCCESS);
        clientAccountMessages.put(ResultCodeDB.NO_DELETE, Message.CLIENT_ACCOUNT_NO_DELETE);

        clientAccountMessages.put(ResultCodeDB.SUCCESS, Message.CLIENT_ACCOUNT_SUCCESS);
        clientAccountMessages.put(ResultCodeDB.NULL_VARIABLE, Message.CLIENT_ACCOUNT_NULL_VARIABLE);
        clientAccountMessages.put(ResultCodeDB.EMPTY_VARIABLE, Message.CLIENT_ACCOUNT_EMPTY_VARIABLE);
        clientAccountMessages.put(ResultCodeDB.TABLE_CODE_EXISTS, Message.CLIENT_ACCOUNT_TABLE_CODE_EXISTS);
        clientAccountMessages.put(ResultCodeDB.FOREIGN_KEY_NOT_EXIST, Message.CLIENT_ACCOUNT_FOREIGN_KEY_NOT_EXIST);
        clientAccountMessages.put(ResultCodeDB.PRIMARY_KEY_NOT_EXIST, Message.CLIENT_ACCOUNT_PRIMARY_KEY_NOT_EXIST);
        clientAccountMessages.put(ResultCodeDB.SPECIAL_CHARACTER_VALUES, Message.SPECIAL_CHARACTER_VALUES);
        clientAccountMessages.put(ResultCodeDB.VALUE_TOO_LONG, Message.VALUE_TOO_LONG);
        // ===========================UBICACION==================================
        ubicationMessages.put(ResultCodeDB.CREATE, Message.UBICATION_CREATE_SUCCESS);
        ubicationMessages.put(ResultCodeDB.UPDATED, Message.UBICATION_UPDATE_SUCCESS);
        ubicationMessages.put(ResultCodeDB.DELETE, Message.UBICATION_DELETE_SUCCESS);

        ubicationMessages.put(ResultCodeDB.SUCCESS, Message.UBICATION_SUCCESS);
        ubicationMessages.put(ResultCodeDB.NULL_VARIABLE, Message.UBICATION_NULL_VARIABLE);
        ubicationMessages.put(ResultCodeDB.EMPTY_VARIABLE, Message.UBICATION_EMPTY_VARIABLE);
        ubicationMessages.put(ResultCodeDB.TABLE_CODE_EXISTS, Message.UBICATION_TABLE_CODE_EXISTS);
        ubicationMessages.put(ResultCodeDB.FOREIGN_KEY_NOT_EXIST, Message.UBICATION_FOREIGN_KEY_NOT_EXIST);
        ubicationMessages.put(ResultCodeDB.PRIMARY_KEY_NOT_EXIST, Message.UBICATION_PRIMARY_KEY_NOT_EXIST);
        ubicationMessages.put(ResultCodeDB.SPECIAL_CHARACTER_VALUES, Message.SPECIAL_CHARACTER_VALUES);
        ubicationMessages.put(ResultCodeDB.VALUE_TOO_LONG, Message.VALUE_TOO_LONG);
        ubicationMessages.put(ResultCodeDB.NO_DELETE, Message.UBICATION_NO_DELETE);
        // ===========================CUENTA_CONTABLE==================================
        cuentaContableMessages.put(ResultCodeDB.CREATE, Message.CUENTA_CONTABLE_CREATE_SUCCESS);
        cuentaContableMessages.put(ResultCodeDB.UPDATED, Message.CUENTA_CONTABLE_UPDATE_SUCCESS);
        cuentaContableMessages.put(ResultCodeDB.DELETE, Message.CUENTA_CONTABLE_DELETE_SUCCESS);
        cuentaContableMessages.put(ResultCodeDB.NO_DELETE, Message.CUENTA_CONTABLE_NO_DELETE);

        cuentaContableMessages.put(ResultCodeDB.SUCCESS, Message.CUENTA_CONTABLE_SUCCESS);
        cuentaContableMessages.put(ResultCodeDB.NULL_VARIABLE, Message.CUENTA_CONTABLE_NULL_VARIABLE);
        cuentaContableMessages.put(ResultCodeDB.EMPTY_VARIABLE, Message.CUENTA_CONTABLE_EMPTY_VARIABLE);
        cuentaContableMessages.put(ResultCodeDB.TABLE_CODE_EXISTS, Message.CUENTA_CONTABLE_TABLE_CODE_EXISTS);
        cuentaContableMessages.put(ResultCodeDB.FOREIGN_KEY_NOT_EXIST, Message.CUENTA_CONTABLE_FOREIGN_KEY_NOT_EXIST);
        cuentaContableMessages.put(ResultCodeDB.PRIMARY_KEY_NOT_EXIST, Message.CUENTA_CONTABLE_PRIMARY_KEY_NOT_EXIST);
        cuentaContableMessages.put(ResultCodeDB.SPECIAL_CHARACTER_VALUES, Message.SPECIAL_CHARACTER_VALUES);
        cuentaContableMessages.put(ResultCodeDB.VALUE_TOO_LONG, Message.VALUE_TOO_LONG);

        // phoneMessages.put(ResultCodeDB.SUCCESS, Message.SUCCESS);
        // phoneMessages.put(ResultCodeDB.PRIMARY_KEY_NOT_EXIST,
        // Message.PRIMARY_KEY_NOT_EXIST);
        // phoneMessages.put(ResultCodeDB.NULL_VARIABLE, Message.NULL_VARIABLE);

        // phoneMessages.put(ResultCodeDB.CREATE, Message.P);
        // phoneMessages.put(ResultCodeDB.UPDATED,
        // Message.EXCHANGE_RATE_UPDATE_SUCCESS);
        // phoneMessages.put(ResultCodeDB.DELETE, Message.EXCHANGE_RATE_DELETE_SUCCESS);

        // Inicializacion de mensajes de execciones
        exeptionsMessages.put(ResultCodeDB.PROCEDURE_NOT_EXECUTED, Message.PROCEDURE_NOT_EXECUTED);
        exeptionsMessages.put(ResultCodeDB.JSON_PROCESSING_EXCEPTION, Message.JSON_PROCESSING_EXCEPTION);
        exeptionsMessages.put(ResultCodeDB.I_LLEGAL_ACCESS_EXCEPTION, Message.I_LLEGAL_ACCESS_EXCEPTION);

        // Inicializacion de mapa padre
        typeMessageMap.put(Banco.class, bankMessages);
        typeMessageMap.put(ClienteInfoDTO.class, clientMessage);
        typeMessageMap.put(Moneda.class, currencyMessages);
        typeMessageMap.put(TipoCambio.class, exchangeRateMessages);
        typeMessageMap.put(Telefono.class, phoneMessages);
        typeMessageMap.put(CuentaCliente.class, clientAccountMessages);
        typeMessageMap.put(Ubicacion.class, ubicationMessages);
        typeMessageMap.put(CuentaContable.class, cuentaContableMessages);
    }

    public <T> Message getMessageByCode(int resultCode, Class<T> type) {

        if (exeptionsMessages.containsKey(resultCode))
            return exeptionsMessages.getOrDefault(resultCode, Message.UNCAUGHT_EXCEPTION);

        return typeMessageMap.getOrDefault(type, exeptionsMessages).getOrDefault(resultCode,
                Message.UNCAUGHT_EXCEPTION);

    }

}
