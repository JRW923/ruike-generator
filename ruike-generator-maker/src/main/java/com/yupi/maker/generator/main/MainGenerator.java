package com.yupi.maker.generator.main;

/**
 * @author: WJR
 * @create: 2025-01-01 19:46
 * @description: 生成代码生成器
 */
public class MainGenerator extends GenerateTemplate {
    @Override
    protected String buildDist(String outputPath, String jarPath, String sourceCopyDestPath, String shellOutputFilePath) {
        System.out.println("不要精简版");
        return "";
    }
}
