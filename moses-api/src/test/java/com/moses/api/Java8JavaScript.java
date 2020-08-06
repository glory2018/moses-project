/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.moses.api.Java8Sort
 * @version V1.0
 */
package com.moses.api;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author Moses
 * @date 2020/6/24
 */
public class Java8JavaScript {
    public static void main(String args[]) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
        String name = "Runoob";
        Integer result = null;
        try {
            nashorn.eval("print('" + name + "')");
            result = (Integer) nashorn.eval("10 + 2");
        } catch (ScriptException e) {
            System.out.println("执行脚本错误: " + e.getMessage());
        }
        System.out.println(result.toString());
    }
}
