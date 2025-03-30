package com.yupi.maker;

import com.yupi.maker.generator.main.GenerateTemplate;
import com.yupi.maker.generator.main.MainGenerator;
import com.yupi.maker.generator.main.ZipGenerator;
import freemarker.template.TemplateException;

import java.io.IOException;

/**
 * @author: WJR
 * @create: 2025-01-01 15:10
 * @description: 全局调用入口
 */
public class Main {
    public static void main(String[] args) throws TemplateException, IOException, InterruptedException {
//        GenerateTemplate generateTemplate = new MainGenerator();
        GenerateTemplate generateTemplate = new ZipGenerator();
        generateTemplate.doGenerate();
    }
}
