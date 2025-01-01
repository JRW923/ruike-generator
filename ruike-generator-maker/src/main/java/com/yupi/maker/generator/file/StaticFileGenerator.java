package com.yupi.maker.generator.file;

import cn.hutool.core.io.FileUtil;

/**
 * @author: WJR
 * @create: 2024-12-30 15:07
 * @description: 静态文件生成器
 */
public class StaticFileGenerator {
    /**
     * 拷贝文件：Hutool 实现，将输入目录完整拷贝到输出目录下
     * @param inputPath
     * @param outputPath
     */
    public static void copyFilesByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath, false);
    }
}
