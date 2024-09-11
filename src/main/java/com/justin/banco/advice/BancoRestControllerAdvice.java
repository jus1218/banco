package com.justin.banco.advice;


import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.justin.banco.controller.BancoController;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice(assignableTypes = BancoController.class)
public class BancoRestControllerAdvice {


}
