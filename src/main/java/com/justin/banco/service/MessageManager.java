package com.justin.banco.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.justin.banco.constants.Message;
import com.justin.banco.constants.ResultCodeDB;
import com.justin.banco.models.Banco;
import com.justin.banco.models.Cliente;
import com.justin.banco.models.Moneda;

@Service
public class MessageManager {
    // Contiene los demas mapas
    private static final Map<Class<?>, Map<Integer, Message>> typeMessageMap = new HashMap<>();

    private static final Map<Integer, Message> messageGenericMap = new HashMap<Integer, Message>();
    private static final Map<Integer, Message> messageClientMap = new HashMap<Integer, Message>();
    private static final Map<Integer, Message> messageBancoMap = new HashMap<Integer, Message>();
    private static final Map<Integer, Message> messageMonedaMap = new HashMap<Integer, Message>();

    static {
        messageGenericMap.put(ResultCodeDB.SUCCESS, Message.SUCCESS);
        messageGenericMap.put(ResultCodeDB.NULL_VARIABLE, Message.NULL_VARIABLE);
        messageGenericMap.put(ResultCodeDB.EMPTY_VARIABLE, Message.EMPTY_VARIABLE);
        messageGenericMap.put(ResultCodeDB.TABLE_CODE_EXISTS, Message.TABLE_CODE_EXISTS);
        messageGenericMap.put(ResultCodeDB.FOREIGN_KEY_NOT_EXIST, Message.FOREIGN_KEY_NOT_EXIST);
        messageGenericMap.put(ResultCodeDB.PRIMARY_KEY_NOT_EXIST, Message.PRIMARY_KEY_NOT_EXIST);
        messageGenericMap.put(ResultCodeDB.SPECIAL_CHARACTER_VALUES, Message.SPECIAL_CHARACTER_VALUES);
        messageGenericMap.put(ResultCodeDB.VALUE_TOO_LONG, Message.VALUE_TOO_LONG);
        // Inicializacion de mensajes para Cliente
        messageClientMap.put(ResultCodeDB.SUCCESS, Message.CLIENT_SUCCESS);
        messageClientMap.put(ResultCodeDB.NULL_VARIABLE, Message.CLIENT_NULL_VARIABLE);
        messageClientMap.put(ResultCodeDB.EMPTY_VARIABLE, Message.CLIENT_EMPTY_VARIABLE);
        messageClientMap.put(ResultCodeDB.TABLE_CODE_EXISTS, Message.CLIENT_TABLE_CODE_EXISTS);
        messageClientMap.put(ResultCodeDB.FOREIGN_KEY_NOT_EXIST, Message.CLIENT_FOREIGN_KEY_NOT_EXIST);
        messageClientMap.put(ResultCodeDB.PRIMARY_KEY_NOT_EXIST, Message.CLIENT_PRIMARY_KEY_NOT_EXIST);
        messageClientMap.put(ResultCodeDB.SPECIAL_CHARACTER_VALUES, Message.SPECIAL_CHARACTER_VALUES);
        messageClientMap.put(ResultCodeDB.VALUE_TOO_LONG, Message.VALUE_TOO_LONG);
        // Inicializacion de mensajes para Banco
        messageBancoMap.put(ResultCodeDB.SUCCESS, Message.BANK_SUCCESS);
        messageBancoMap.put(ResultCodeDB.NULL_VARIABLE, Message.BANK_NULL_VARIABLE);
        messageBancoMap.put(ResultCodeDB.EMPTY_VARIABLE, Message.BANK_EMPTY_VARIABLE);
        messageBancoMap.put(ResultCodeDB.TABLE_CODE_EXISTS, Message.BANK_TABLE_CODE_EXISTS);
        messageBancoMap.put(ResultCodeDB.FOREIGN_KEY_NOT_EXIST, Message.BANK_FOREIGN_KEY_NOT_EXIST);
        messageBancoMap.put(ResultCodeDB.PRIMARY_KEY_NOT_EXIST, Message.BANK_PRIMARY_KEY_NOT_EXIST);
        messageBancoMap.put(ResultCodeDB.SPECIAL_CHARACTER_VALUES, Message.SPECIAL_CHARACTER_VALUES);
        messageBancoMap.put(ResultCodeDB.VALUE_TOO_LONG, Message.VALUE_TOO_LONG);
        // Inicializacion de mensajes para Moneda
        messageMonedaMap.put(ResultCodeDB.SUCCESS, Message.CURRENCY_SUCCESS);
        messageMonedaMap.put(ResultCodeDB.NULL_VARIABLE, Message.CURRENCY_NULL_VARIABLE);
        messageMonedaMap.put(ResultCodeDB.EMPTY_VARIABLE, Message.CURRENCY_EMPTY_VARIABLE);
        messageMonedaMap.put(ResultCodeDB.TABLE_CODE_EXISTS, Message.CURRENCY_TABLE_CODE_EXISTS);
        messageMonedaMap.put(ResultCodeDB.PRIMARY_KEY_NOT_EXIST, Message.CURRENCY_PRIMARY_KEY_NOT_EXIST);
        messageMonedaMap.put(ResultCodeDB.SPECIAL_CHARACTER_VALUES, Message.SPECIAL_CHARACTER_VALUES);
        messageMonedaMap.put(ResultCodeDB.VALUE_TOO_LONG, Message.VALUE_TOO_LONG);
        // Inicializacion de mapa padre
        typeMessageMap.put(Banco.class, messageBancoMap);
        typeMessageMap.put(Cliente.class, messageClientMap);
        typeMessageMap.put(Moneda.class, messageMonedaMap);
    }

    public <T> Message getMessageByCode(int resultCode, Class<T> type) {

        if (resultCode == ResultCodeDB.PROCEDURE_NOT_EXECUTED)
            return Message.PROCEDURE_NOT_EXECUTED;

        return typeMessageMap.get(type).get(resultCode);

    }

}
