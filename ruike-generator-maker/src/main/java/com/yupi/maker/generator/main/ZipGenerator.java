package com.yupi.maker.generator.main;

/**
 * @author: WJR
 * @create: 2025-01-01 19:46
 * @description: 生成代码生成器压缩包
 */
public class ZipGenerator extends GenerateTemplate {
    @Override
    protected String buildDist(String outputPath, String jarPath, String sourceCopyDestPath, String shellOutputFilePath) {
        String distPath = super.buildDist(outputPath, jarPath, sourceCopyDestPath, shellOutputFilePath);
        return super.buildZip(distPath);
    }
}
