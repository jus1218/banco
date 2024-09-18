package com.justin.banco.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.justin.banco.constants.Message;
import com.justin.banco.constants.ResultCodeDB;
import com.justin.banco.dto.cliente.ClienteInfoDTO;
import com.justin.banco.models.Banco;
import com.justin.banco.models.Moneda;

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
        clientMessage.put(ResultCodeDB.SUCCESS, Message.CLIENT_SUCCESS);
        clientMessage.put(ResultCodeDB.NULL_VARIABLE, Message.CLIENT_NULL_VARIABLE);
        clientMessage.put(ResultCodeDB.EMPTY_VARIABLE, Message.CLIENT_EMPTY_VARIABLE);
        clientMessage.put(ResultCodeDB.TABLE_CODE_EXISTS, Message.CLIENT_TABLE_CODE_EXISTS);
        clientMessage.put(ResultCodeDB.FOREIGN_KEY_NOT_EXIST, Message.CLIENT_FOREIGN_KEY_NOT_EXIST);
        clientMessage.put(ResultCodeDB.PRIMARY_KEY_NOT_EXIST, Message.CLIENT_PRIMARY_KEY_NOT_EXIST);
        clientMessage.put(ResultCodeDB.SPECIAL_CHARACTER_VALUES, Message.SPECIAL_CHARACTER_VALUES);
        clientMessage.put(ResultCodeDB.VALUE_TOO_LONG, Message.VALUE_TOO_LONG);
        // Inicializacion de mensajes para Banco
        bankMessages.put(ResultCodeDB.SUCCESS, Message.BANK_SUCCESS);
        bankMessages.put(ResultCodeDB.NULL_VARIABLE, Message.BANK_NULL_VARIABLE);
        bankMessages.put(ResultCodeDB.EMPTY_VARIABLE, Message.BANK_EMPTY_VARIABLE);
        bankMessages.put(ResultCodeDB.TABLE_CODE_EXISTS, Message.BANK_TABLE_CODE_EXISTS);
        bankMessages.put(ResultCodeDB.FOREIGN_KEY_NOT_EXIST, Message.BANK_FOREIGN_KEY_NOT_EXIST);
        bankMessages.put(ResultCodeDB.PRIMARY_KEY_NOT_EXIST, Message.BANK_PRIMARY_KEY_NOT_EXIST);
        bankMessages.put(ResultCodeDB.SPECIAL_CHARACTER_VALUES, Message.SPECIAL_CHARACTER_VALUES);
        bankMessages.put(ResultCodeDB.VALUE_TOO_LONG, Message.VALUE_TOO_LONG);
        // Inicializacion de mensajes para Moneda
        currencyMessages.put(ResultCodeDB.SUCCESS, Message.CURRENCY_SUCCESS);
        currencyMessages.put(ResultCodeDB.NULL_VARIABLE, Message.CURRENCY_NULL_VARIABLE);
        currencyMessages.put(ResultCodeDB.EMPTY_VARIABLE, Message.CURRENCY_EMPTY_VARIABLE);
        currencyMessages.put(ResultCodeDB.TABLE_CODE_EXISTS, Message.CURRENCY_TABLE_CODE_EXISTS);
        currencyMessages.put(ResultCodeDB.PRIMARY_KEY_NOT_EXIST, Message.CURRENCY_PRIMARY_KEY_NOT_EXIST);
        currencyMessages.put(ResultCodeDB.SPECIAL_CHARACTER_VALUES, Message.SPECIAL_CHARACTER_VALUES);
        currencyMessages.put(ResultCodeDB.VALUE_TOO_LONG, Message.VALUE_TOO_LONG);
        // Inicializacion de mensajes de execciones
        exeptionsMessages.put(ResultCodeDB.PROCEDURE_NOT_EXECUTED, Message.PROCEDURE_NOT_EXECUTED);
        exeptionsMessages.put(ResultCodeDB.JSON_PROCESSING_EXCEPTION, Message.JSON_PROCESSING_EXCEPTION);
        exeptionsMessages.put(ResultCodeDB.I_LLEGAL_ACCESS_EXCEPTION, Message.I_LLEGAL_ACCESS_EXCEPTION);

        // Inicializacion de mapa padre
        typeMessageMap.put(Banco.class, bankMessages);
        typeMessageMap.put(ClienteInfoDTO.class, clientMessage);
        typeMessageMap.put(Moneda.class, currencyMessages);
    }

    public <T> Message getMessageByCode(int resultCode, Class<T> type) {

        if (exeptionsMessages.containsKey(resultCode))
            return exeptionsMessages.getOrDefault(resultCode, Message.UNCAUGHT_EXCEPTION);

        return typeMessageMap.getOrDefault(type, exeptionsMessages).getOrDefault(resultCode,
                Message.UNCAUGHT_EXCEPTION);

    }
}
