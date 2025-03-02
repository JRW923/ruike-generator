package com.yupi.maker.generator.file;

import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * @author: WJR
 * @create: 2024-12-30 20:15
 * @description: 动静结合，生成完整代码
 */
public class FileGenerator {
    public static void doGenerate(Object model) throws IOException, TemplateException {
        String projectPath = System.getProperty("user.dir");
        // 项目根路径
        File parentFile = new File(projectPath).getParentFile();
        // 输入路径
        String inputPath = new File(parentFile,"ruike-generator-demo-projects/acm-template").getAbsolutePath();
        // 输出路径
        String outputPath = projectPath;
        // 复制，生成静态文件
        StaticFileGenerator.copyFilesByHutool(inputPath, outputPath);

        // 2.动态文件生成
        String DynamicInputPath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String DynamicOutputPath = projectPath + File.separator + "acm-template/src/com/yupi/acm/MainTemplate.java";
        DynamicFileGenerator.doGenerate(DynamicInputPath, DynamicOutputPath, model);
    }
}
