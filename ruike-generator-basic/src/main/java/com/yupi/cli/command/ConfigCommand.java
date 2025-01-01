package com.yupi.cli.command;

import cn.hutool.core.util.ReflectUtil;
import com.yupi.model.MainTemplateConfig;
import picocli.CommandLine;

import java.lang.reflect.Field;

/**
 * @author: WJR
 * @create: 2024-12-31 23:55
 * @description: config子命令：查看允许用户传入的动态参数信息
 */
@CommandLine.Command(name = "config", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable {

    @Override
    public void run() {
        Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class);
        for (Field field : fields) {
            System.out.println("字段类型" + field.getType());
            System.out.println("字段名称" + field.getName());
        }
    }
}
