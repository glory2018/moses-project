/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.moses.framework.common.exception.GlobalExceptionHandler
 * @version V1.0
 */
package com.moses.web.exception;

import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Moses
 * @date 2020/7/2
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 参数校验异常
     * @param model
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public String BindExceptionHandler(Model model, BindException e) {
        // 获取所有字段参数不匹配的参数集合
        List<FieldError> fieldErrorList = e.getFieldErrors();
        Map<String, Object> result = new HashMap<>(fieldErrorList.size());
        fieldErrorList.forEach(error -> {
            // 将错误参数名称和参数错误原因存于map集合中
            result.put(error.getField(), error.getDefaultMessage());
        });
        model.addAttribute("errors", result);
        return "error/412";
    }
}
