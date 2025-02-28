package com.yupi.maker.generator.main;

import freemarker.template.TemplateException;

import java.io.IOException;

/**
 * @author: WJR
 * @create: 2025-01-01 19:46
 * @description: 测试代码
 */
public class MainGenerator extends GenerateTemplate {
    @Override
    protected void buildDist(String outputPath, String jarPath, String sourceCopyDestPath, String shellOutputFilePath) {
        System.out.println("不要精简版");
    }
}
